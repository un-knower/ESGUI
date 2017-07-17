package com.believeus.ESGUI.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believeus.ESGUI.dao.FileMetaDataDao;
import com.believeus.ESGUI.fileGenerate.FileGenerate;
import com.believeus.ESGUI.model.FileMetaData;
import com.believeus.ESGUI.service.FileMetaDataService;

@Service("fileMetaDataService")
@Transactional
public class FileMetaDataServiceImpl implements FileMetaDataService{

	@Autowired
	private FileMetaDataDao fileMetaDataDao;

	@Override
	public List<FileMetaData> findByContent(String content) {
		return fileMetaDataDao.findByContent(content);
	}

	@Override
	public FileMetaData save(FileMetaData fileMetaData) {
		return fileMetaDataDao.save(fileMetaData);
	}

	@Override
	public void convertFileMetaData(FileGenerate fileGenerate, File file) {
		save(fileGenerate.fileMetaData(file));
	}
	
}
