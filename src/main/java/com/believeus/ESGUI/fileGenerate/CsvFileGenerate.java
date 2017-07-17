package com.believeus.ESGUI.fileGenerate;

import java.io.File;

import com.believeus.ESGUI.model.FileMetaData;
import com.believeus.ESGUI.util.CSVUtil;
import com.google.common.collect.Table;

public class CsvFileGenerate implements FileGenerate{

	@Override
	public FileMetaData fileMetaData(File file) {
		// 设置默认属性
		FileMetaData fileMetaData = defaultMetaData(file, new FileMetaData());
		
		Table<Integer, String, Object> excelTable = CSVUtil.readCsv(file);
		StringBuilder sb = new StringBuilder();
		
		excelTable.rowMap().forEach((key,value)->{
			value.forEach((subKey,subValue)->{
				sb.append(subValue+"\t");
			});
		});
		
		fileMetaData.setContent(sb.toString());
		
		return fileMetaData;
	}

}
