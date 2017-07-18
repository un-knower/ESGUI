package com.believeus.ESGUI.fileGenerate;

import java.io.File;

import org.springframework.stereotype.Component;

import com.anosi.asset.exception.CustomRunTimeException;

@Component
public class FileGenerateAdapter {

	public FileGenerate adapter(File file){
		String suffix = file.getName().substring(file.getName().lastIndexOf(".")+1);
		switch (suffix) {
		case "txt":
			return new TxtFileGenerate();
		case "doc":
			return new WordFileGenerate();
		case "xlsx":
			return new ExcelFileGenerate();
		case "csv":
			return new CsvFileGenerate();
		default:
			throw new CustomRunTimeException("不支持该类型文件:"+suffix);
		}
	}
	
}
