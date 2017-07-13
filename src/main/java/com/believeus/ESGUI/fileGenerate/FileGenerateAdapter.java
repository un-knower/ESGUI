package com.believeus.ESGUI.fileGenerate;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anosi.asset.exception.CustomRunTimeException;
import com.believeus.ESGUI.service.FileMetaDataService;

@Component
public class FileGenerateAdapter {
	
	@Autowired
	private FileMetaDataService fileMetaDataService;
	@Autowired
	private TxtFileGenerate txtFileGenerate;

	public void adapter(File file){
		String suffix = file.getName().substring(file.getName().lastIndexOf("."));
		switch (suffix) {
		case "txt":
			fileMetaDataService.save(txtFileGenerate.fileMetaData(file));
			break;
		case "doc":
			
			break;
		case "xlsx":
			
			break;
		case "csv":
			
			break;
		default:
			throw new CustomRunTimeException("不支持该类型文件:"+suffix);
		}
	}
	
}
