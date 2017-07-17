package com.believeus.ESGUI.fileGenerate;

import java.io.File;
import java.io.IOException;

import com.believeus.ESGUI.model.FileMetaData;
import com.believeus.ESGUI.util.WordUtil;

public class WordFileGenerate implements FileGenerate {

	@Override
	public FileMetaData fileMetaData(File file) {
		// 设置默认属性
		FileMetaData fileMetaData = defaultMetaData(file, new FileMetaData());
		try {
			fileMetaData.setContent(WordUtil.readWord(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileMetaData;
	}

}
