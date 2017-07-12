package com.believeus.ESGUI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class EsguiApplication extends AbstractJavaFxApplicationSupport {

	@Value("${app.ui.title}")//
	private String windowTitle;
	
	public static void main(String[] args) {
		launchApp(EsguiApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/index.fxml"));

		primaryStage.setTitle(windowTitle);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		//窗口关闭事件
		primaryStage.setOnCloseRequest(event->
			System.out.print("窗口关闭")
		);
	}
}
