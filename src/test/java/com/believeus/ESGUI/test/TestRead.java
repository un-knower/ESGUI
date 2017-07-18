package com.believeus.ESGUI.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.believeus.ESGUI.util.CSVUtil;
import com.believeus.ESGUI.util.ExcelUtil;
import com.believeus.ESGUI.util.TxtUtil;
import com.believeus.ESGUI.util.WordUtil;
import com.google.common.collect.Table;

public class TestRead {

	@Test
	public void testReadCsv(){
		Table<Integer, String, Object> csvTable = CSVUtil.readCsv(new File("F:/basestation/result/result.csv"));
		StringBuilder sb = new StringBuilder();
		
		csvTable.rowMap().forEach((key,value)->{
			value.forEach((subKey,subValue)->{
				sb.append(subValue+"\t");
			});
		});
		System.out.println(sb.toString());
	}
	
	@Test
	public void testReadWord(){
		try {
			System.out.println(WordUtil.readWord(new File("F:/basestation/result/testDoc.docx")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReadTxt(){
		try {
			System.out.println(TxtUtil.readTxt(new File("F:/basestation/result/test.txt")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReadExcel() throws IOException{
		Table<Integer, String, Object> excelTable = ExcelUtil.readExcel(new File("F:/20161226155537.xlsx"), 0);
		StringBuilder sb = new StringBuilder();
		
		excelTable.rowMap().forEach((key,value)->{
			value.forEach((subKey,subValue)->{
				sb.append(subValue+"\t");
			});
		});
		
		System.out.println(sb.toString());
	}
	
}
