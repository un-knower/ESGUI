package com.believeus.ESGUI.service;

import java.util.List;

import com.believeus.ESGUI.model.FileMetaData;

public interface FileMetaDataService {
	
	public FileMetaData save(FileMetaData fileMetaData);
	
	public List<FileMetaData> findByContent(String content);
	
}
