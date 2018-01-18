package com.liao;

import java.io.File;

import java.io.FileOutputStream;

import com.aspose.cells.Workbook;
import com.aspose.slides.Presentation;
import com.aspose.words.Document;

public class OfficeToPdf {
    public static void main(String[] args) {
        try {
            String wordPath = "/home/hongyangliao/Documents/work/北京市地铁运营有限公司共享数据需求申请表_模板.doc";
            //String excelPath = "E:/1.xls";
            //String pptPath = "E:/1.ppt";
            /*WordToPdf(wordPath);
			ExcelToPdf(excelPath);*/
            //PPTToPdf(pptPath);
            WordToPdf(wordPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将word转为pdf
     *
     * @param Address
     */
    public static void WordToPdf(String wordPath) {
        //验证License 若不验证则转化出的pdf文档会有水印产生
        if (!OfficeToPdfLicense.getWordLicense())
            return;
        try {
            long old = System.currentTimeMillis();
            //新建一个空白pdf文档
            File file = new File("/home/hongyangliao/Documents/work/1.pdf");
            FileOutputStream fileOS = new FileOutputStream(file);
            Document doc = new Document(wordPath);
            //可以手动加水印，但是格式需要好好调理，我不需要这个功能，请自行查询
            /*Compile.insertWatermarkText(doc, "云集出版");*/
            doc.save(fileOS, com.aspose.words.SaveFormat.PDF);
            fileOS.close();
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old)/1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将Excel转为pdf
     *
     * @param Address
     */
    public static void ExcelToPdf(String excelPath) {
        if (!OfficeToPdfLicense.getExcelLicense()) {
            return;
        }
        try {
            long old = System.currentTimeMillis();
            Workbook wb = new Workbook(excelPath);
            File file = new File("E:/excel.pdf");
            FileOutputStream fileOS = new FileOutputStream(file);
            wb.save(fileOS, com.aspose.cells.SaveFormat.PDF);
            fileOS.close();
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old)/1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将PPT转为pdf
     *
     * @param Address
     */
    public static void PPTToPdf(String pptPath) {
        if (!OfficeToPdfLicense.getPPTLicense()) {
            return;
        }
        try {
            long old = System.currentTimeMillis();
            Presentation ppt = new Presentation(pptPath);
            File file = new File("E:/ppt.pdf");
            FileOutputStream fileOS = new FileOutputStream(file);
            ppt.save(fileOS, com.aspose.slides.SaveFormat.Pdf);
            fileOS.close();
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old)/1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
