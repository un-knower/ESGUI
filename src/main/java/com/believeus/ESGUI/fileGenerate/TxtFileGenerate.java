package com.believeus.ESGUI.fileGenerate;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import com.believeus.ESGUI.model.FileMetaData;

/***
 * 为txt文件建立metaData
 * @author jinyao
 *
 */
@Component
public class TxtFileGenerate implements FileGenerate{

	@Override
	public FileMetaData fileMetaData(File file) {
		//设置默认属性
		FileMetaData fileMetaData = defaultMetaData(file, new FileMetaData());
		try {
			//TODO 测试字符集
			fileMetaData.setContent(FileUtils.readFileToString(file,Charset.defaultCharset()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileMetaData;
	}

}
