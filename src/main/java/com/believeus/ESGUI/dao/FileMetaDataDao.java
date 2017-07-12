package com.believeus.ESGUI.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.believeus.ESGUI.model.FileMetaData;

public interface FileMetaDataDao extends ElasticsearchRepository<FileMetaData, Long>{

	public List<FileMetaData> findByContent(String content);
	
}
