package com.believeus.ESGUI.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;

import com.believeus.ESGUI.service.FileMetaDataService;

import javafx.event.ActionEvent;

public class IndexController {
	@FXML
	private Button search;
	@FXML
	private TextField searchContent;
	@Autowired
	private FileMetaDataService fileMetaDataService;

	// Event Listener on Button[#search].onAction
	@FXML
	public void search(ActionEvent event) {
		fileMetaDataService.findByContent(searchContent.getText());
	}
}
