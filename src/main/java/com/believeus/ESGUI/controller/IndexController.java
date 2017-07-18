package com.believeus.ESGUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.anosi.asset.exception.CustomRunTimeException;
import com.believeus.ESGUI.EsguiApplication;
import com.believeus.ESGUI.fileGenerate.FileGenerate;
import com.believeus.ESGUI.fileGenerate.FileGenerateAdapter;
import com.believeus.ESGUI.model.FileMetaData;
import com.believeus.ESGUI.service.FileMetaDataService;
import com.believeus.ESGUI.view.ResultView;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;

@FXMLController
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@FXML
	private Button search;
	@FXML
	private Button choose;
	@FXML
	private TextField searchContent;
	@Autowired
	private FileMetaDataService fileMetaDataService;
	@Autowired
	private FileGenerateAdapter fileGenerateAdapter;

	// Event Listener on Button[#search].onAction
	@FXML
	public void search(ActionEvent event) {
		List<FileMetaData> findByContent = fileMetaDataService.findByContent(searchContent.getText());
		findByContent.forEach(fileMetaData->logger.debug(fileMetaData.getName()));
		//跳转
		EsguiApplication.showView(ResultView.class);
	}
	
	@FXML
	public void chooseFile(ActionEvent event) {
		Stage stage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择需要索引的文件");
		File file = fileChooser.showOpenDialog(stage);// 返回选中文件
		logger.debug("选取文件:{},路径:{}", file.getName(), file.getAbsolutePath());

		// 索引文件
		try {
			FileGenerate fileGenerate = fileGenerateAdapter.adapter(file);
			fileMetaDataService.convertFileMetaData(fileGenerate, file);
		} catch (Exception e) {
			String message="";
			if (e instanceof CustomRunTimeException) {
				message=e.getMessage();
			} else {
				message="出错了！";
			}
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("出错了！");
			alert.setHeaderText(null);
			alert.setContentText(message);

			alert.showAndWait();
		}
	}
}
