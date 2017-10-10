package com.ducetech.framework.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;

/**
 * pdf工具类
 *
 * @ClassName: PdfUtils
 * @Date 17-10-10 上午10:56
 */
public class PdfUtils {
	/**
	 * 获得中文字体
	 *
	 * @param
	 * @return com.itextpdf.text.Font 中文字体
	 * @throws
	 * @Title: getPdfChineseFont
	 * @Date: 17-10-10 上午10:57
	 */
	public static Font getPdfChineseFont() throws Exception {
		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
		return fontChinese;
	}
}
