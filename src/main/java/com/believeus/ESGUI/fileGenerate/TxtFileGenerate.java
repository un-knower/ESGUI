package com.believeus.ESGUI.fileGenerate;

import java.io.File;

import org.springframework.stereotype.Component;

import com.believeus.ESGUI.model.FileMetaData;
import com.believeus.ESGUI.util.TxtUtil;

/***
 * 为txt文件建立metaData
 * @author jinyao
 *
 */
@Component
public class TxtFileGenerate implements FileGenerate{

	@Override
	public FileMetaData fileMetaData(File file) {
		//设置默认属性
		FileMetaData fileMetaData = defaultMetaData(file, new FileMetaData());
		fileMetaData.setContent(TxtUtil.readTxt(file));
		return fileMetaData;
	}

}
