package com.believeus.ESGUI.fileGenerate;

import java.io.File;
import java.io.IOException;

import com.believeus.ESGUI.model.FileMetaData;
import com.believeus.ESGUI.util.ExcelUtil;
import com.google.common.collect.Table;

public class ExcelFileGenerate implements FileGenerate{

	@Override
	public FileMetaData fileMetaData(File file) {
		// 设置默认属性
		FileMetaData fileMetaData = defaultMetaData(file, new FileMetaData());
		try {
			Table<Integer, String, Object> excelTable = ExcelUtil.readExcel(file, -1);
			StringBuilder sb = new StringBuilder();
			
			excelTable.rowMap().forEach((key,value)->{
				value.forEach((subKey,subValue)->{
					sb.append(subValue+"\t");
				});
			});
			
			fileMetaData.setContent(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileMetaData;
	}

}
