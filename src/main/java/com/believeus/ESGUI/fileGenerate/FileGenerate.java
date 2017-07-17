package com.believeus.ESGUI.fileGenerate;

import java.io.File;


import com.believeus.ESGUI.model.FileMetaData;

public interface FileGenerate {

	public FileMetaData fileMetaData(File file);
	
	default public FileMetaData defaultMetaData(File file,FileMetaData fileMetaData) {
		fileMetaData.setName(file.getName());
		fileMetaData.setSuffix(file.getName().substring(file.getName().lastIndexOf(".")));
		fileMetaData.setPath(file.getAbsolutePath());
		return fileMetaData;
	}
	
}
