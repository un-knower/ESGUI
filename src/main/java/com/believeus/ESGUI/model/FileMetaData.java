package com.believeus.ESGUI.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="esgui",type="fileMetaData",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class FileMetaData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6124251801958183516L;

	private String id;
	
	private String content;
	
	private String path;
	
	private String name;
	
	private String suffix;
	
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
}
