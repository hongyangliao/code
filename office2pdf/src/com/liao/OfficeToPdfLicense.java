package com.liao;

import java.io.InputStream;




public class OfficeToPdfLicense {
	/**
     * 获取Word的license签字验证
     * @return
     */
	public static boolean getWordLicense() {
        boolean result = false;
        InputStream is = null;
        try {
        	is = OfficeToPdfLicense.class.getClassLoader().getResourceAsStream("license.xml");
        	com.aspose.words.License aposeLic = new com.aspose.words.License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(is);
        }
        return result;
    }
	/**
     * 获取Excel的license签字验证
     * @return
     */
	public static boolean getExcelLicense() {
        boolean result = false;
        InputStream is = null;
        try {
        	is = OfficeToPdfLicense.class.getClassLoader().getResourceAsStream("license.xml");
        	com.aspose.cells.License aposeLic = new com.aspose.cells.License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(is);
        }
        return result;
    }
	/**
     * 获取PPT的license
     * @return
     */
    public static boolean getPPTLicense() {
        boolean result = false;
        InputStream is = null;
        try {
        	is = OfficeToPdfLicense.class.getClassLoader().getResourceAsStream("license.xml");
        	com.aspose.slides.License aposeLic = new com.aspose.slides.License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(is);
        }
        return result;
    }
}
