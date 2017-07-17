package com.believeus.ESGUI.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.anosi.asset.exception.CustomRunTimeException;
import com.believeus.ESGUI.fileGenerate.FileGenerateAdapter;

import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

@FXMLController
public class RootLayoutController {

	private static final Logger logger = LoggerFactory.getLogger(RootLayoutController.class);

	@FXML
	private MenuItem indexFile;
	@FXML
	private MenuItem close;
	@Autowired
	private FileGenerateAdapter fileGenerateAdapter;

	// Event Listener on MenuItem[#indexFile].onAction
	@FXML
	public void chooseFile(ActionEvent event) {
		Stage stage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择需要索引的文件");
		File file = fileChooser.showOpenDialog(stage);// 返回选中文件
		logger.debug("选取文件:{},路径:{}", file.getName(), file.getAbsolutePath());

		// 索引文件
		try {
			fileGenerateAdapter.adapter(file);
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

	// Event Listener on MenuItem[#close].onAction
	@FXML
	public void closeWindow(ActionEvent event) {
		 Platform.exit();
	}
}
