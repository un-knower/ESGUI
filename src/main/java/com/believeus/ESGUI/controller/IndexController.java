package com.believeus.ESGUI.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;

public class IndexController {
	@FXML
	private Button myButton;
	@FXML
	private TextField myTextField;

	// Event Listener on Button[#myButton].onAction
	@FXML
	public void showTime(ActionEvent event) {
		Date now = new Date();

		DateFormat df = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		String dateTimeString = df.format(now);
		// Show in VIEW
		myTextField.setText(dateTimeString);
	}
}
