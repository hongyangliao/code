package com.ducetech.framework.util;

import com.google.common.collect.Maps;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码工具类
 *
 * @ClassName: QrcodeUtils
 * @Date 17-10-10 下午1:07
 */
public class QrcodeUtils {

	private static final int BLACK = 0xff000000;
	private static final int RED = 0xffff0000;
	private static final int WHITE = 0xFFFFFFFF;

	/**
	 * 生成二维码
	 *
	 * @param content 内容
	 * @param height  高度
	 * @return java.awt.image.BufferedImage
	 * @throws
	 * @Title: createQrcode
	 * @Date: 17-10-10 下午1:09
	 */
	public static BufferedImage createQrcode(String content, Integer height) {
		return createQrcode(content, height, null);
	}

	/**
	 * 生成二维码
	 *
	 * @param content  内容
	 * @param height   高度
	 * @param logoPath logo路径
	 * @return java.awt.image.BufferedImage
	 * @throws
	 * @Title: createQrcode
	 * @Date: 17-10-10 下午1:17
	 */
	public static BufferedImage createQrcode(String content, Integer height, String logoPath) {
		if (height == null || height < 100) {
			height = 200;
		}

		int logoHeight = height/5;

		try {
			Map<EncodeHintType, Object> hints = Maps.newHashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			hints.put(EncodeHintType.MARGIN, 0);
			BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, height, height, hints);

			int width = bitMatrix.getWidth();
			BufferedImage image = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getHeight(), BufferedImage.TYPE_INT_ARGB);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
				}
			}

			if (logoPath == null) {
				return image;
			}

			Graphics2D g = image.createGraphics();

			BufferedImage logo = scale(logoPath, logoHeight, logoHeight, false);

			int widthLogo = logo.getWidth();
			int heightLogo = logo.getHeight();

			// 计算图片放置位置
			int x = (image.getWidth() - widthLogo)/2;
			int y = (image.getHeight() - logo.getHeight())/2;

			//开始绘制图片
			g.drawImage(logo, x, y, widthLogo, heightLogo, null);
			g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
			g.setStroke(new BasicStroke(1));
			g.setColor(Color.white);
			g.drawRect(x, y, widthLogo, heightLogo);

			g.dispose();

			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 把传入的原始图像按高度和宽度进行缩放,生成符合要求的图片
	 *
	 * @param srcImageFile 源文件地址
	 * @param height       目标高度
	 * @param width        目标宽度
	 * @param hasFiller    比例不对时是否需要补白： true 补白 false 不补白
	 * @return java.awt.image.BufferedImage
	 * @throws
	 * @Title: scale
	 * @Date: 17-10-10 下午1:18
	 */
	private static BufferedImage scale(String srcImageFile, int height, int width, boolean hasFiller) throws IOException {
		double ratio = 0;//缩放比例
		File file = new File(srcImageFile);
		BufferedImage srcImage = ImageIO.read(file);
		Image destImage = srcImage.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);

		//计算比例
		if (srcImage.getHeight() > height || srcImage.getWidth() > width) {
			if (srcImage.getHeight() > srcImage.getWidth()) {
				ratio = Integer.valueOf(height).doubleValue()/srcImage.getHeight();
			} else {
				ratio = Integer.valueOf(width).doubleValue()/srcImage.getWidth();
			}
		} else {
			ratio = 1;
		}

		AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
		destImage = op.filter(srcImage, null);

		//是否补白
		if (hasFiller) {
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphics2d = image.createGraphics();
			graphics2d.setColor(Color.white);
			graphics2d.fillRect(0, 0, width, height);
			if (width == destImage.getWidth(null)) {
				graphics2d.drawImage(destImage, 0, (height - destImage.getHeight(null))/2, destImage.getWidth(null), destImage.getHeight(null),
						Color.white, null);
			} else {
				graphics2d.drawImage(destImage, 0, (width - destImage.getWidth(null))/2, destImage.getWidth(null), destImage.getHeight(null),
						Color.white, null);
			}

			graphics2d.dispose();
			destImage = image;
		}

		return (BufferedImage) destImage;
	}

	/**
	 * 生成二维码图片
	 *
	 * @param content 二维码内容
	 * @param height  二维码高度
	 * @param file    图片地址
	 * @return void
	 * @throws
	 * @Title: createQrcodeImage
	 * @Date: 17-10-10 下午1:19
	 */
	public static void createQrcodeImage(String content, Integer height, File file) throws IOException {
		BufferedImage image = createQrcode(content, height);
		ImageIO.write(image, "png", file);
	}

	/**
	 * 解析二维码内容
	 *
	 * @param file 图片地址
	 * @return java.lang.String 二维码内容
	 * @throws
	 * @Title: decodeQrcode
	 * @Date: 17-10-10 下午1:20
	 */
	public static String decodeQrcode(File file) {
		BufferedImage image;
		try {
			if (file == null || file.exists() == false) {
				throw new Exception(" File not found:" + file.getPath());
			}

			image = ImageIO.read(file);

			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new QRCodeReader().decode(bitmap, hints);

			return result.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//实例
	public static void main(String[] args) throws Exception {
		File file = new File("/home/lenzhao/code/1.png");
		QrcodeUtils.createQrcodeImage("中华人民共和国", 200, file);

		System.out.println("-----成生成功----");
		System.out.println();

		String s = QrcodeUtils.decodeQrcode(file);

		System.out.println("-----解析成功----");
		System.out.println(s);

        /*String srcFile = "d://head-portrait.jpg";
		String destFile = "d://kfcLogo.png";
        String content = "肯德基好味道";
        BufferedImage image = createQrcode(content, 600, srcFile);
        ImageIO.write(image, "png", new File(destFile));
        System.out.println("-----成生成功----");

        String result = QrcodeUtil.decodeQrcode(new File(destFile));
        if (content.endsWith(result)) {
            System.out.println("-----解析成功----");
        }*/
	}
}