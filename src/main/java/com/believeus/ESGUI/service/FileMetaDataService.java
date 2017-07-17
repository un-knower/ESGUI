package com.believeus.ESGUI.service;

import java.io.File;
import java.util.List;

import com.believeus.ESGUI.fileGenerate.FileGenerate;
import com.believeus.ESGUI.model.FileMetaData;

public interface FileMetaDataService {
	
	public void convertFileMetaData(FileGenerate fileGenerate,File file);
	
	public FileMetaData save(FileMetaData fileMetaData);
	
	public List<FileMetaData> findByContent(String content);
	
}
