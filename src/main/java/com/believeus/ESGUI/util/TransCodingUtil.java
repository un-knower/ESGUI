package com.believeus.ESGUI.util;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;

/****
 * 将文件转换成指定编码
 * @author jinyao
 *
 */
public class TransCodingUtil {
	
    public static String getFileEncoding(File file) {
        return getFileCharacterEnding(file);
    }
    /**
     * Try to get file character ending.
     * </p>
     * <strong>Warning: </strong>use cpDetector to detect file's encoding.
     * 
     * @param file
     * @return
     */
    @SuppressWarnings("deprecation")
	public static String getFileCharacterEnding(File file) {
        String fileCharacterEnding = "UTF-8";
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
        detector.add(JChardetFacade.getInstance());
        Charset charset = null;
        // File f = new File(filePath);
        try {
            charset = detector.detectCodepage(file.toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (charset != null) {
            fileCharacterEnding = charset.name();
        }
        return fileCharacterEnding;
    }
    
    /***
     * 将文件转换成指定编码
     * @param fileName
     * @param encoding
     * @return 返回0代表不需要转码，返回1代表转码完成
     * @throws Exception 
     */
    public static int transCoding(File file,File filePath,String encoding) throws Exception{
    	String codeString = getFileEncoding(file);
    	if(!encoding.equals(codeString)){
    		//将文件从codeString转为encoding
        	FileUtils.writeLines(filePath, encoding, FileUtils.readLines(file, codeString));
        	return 1;
    	}
    	return 0;
    }
    
}
