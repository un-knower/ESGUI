package com.believeus.ESGUI.util;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class TxtUtil {

	public static String readTxt(File file){
		//进行文件转码
		File transFile = new File(file.getAbsolutePath()+"_tran.readed");
		int result;
		try {
			result = TransCodingUtil.transCoding(file, transFile, "UTF-8");
			//不需要转码
			if(result==0){
				return FileUtils.readFileToString(file,Charset.defaultCharset());
			}else{
				return FileUtils.readFileToString(transFile,Charset.defaultCharset());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
}
