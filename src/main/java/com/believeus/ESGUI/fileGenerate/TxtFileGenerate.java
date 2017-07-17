package com.believeus.ESGUI.fileGenerate;

import java.io.File;

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
		FileMetaData fileMetaData = new FileMetaData();
		return fileMetaData;
	}

}
