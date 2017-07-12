package com.believeus.ESGUI;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

@SpringBootApplication
public class EsguiApplication extends AbstractJavaFxApplicationSupport {

	@Value("${app.ui.title}") //
	private String windowTitle;

	private Stage primaryStage;

	private BorderPane rootLayout;

	public static void main(String[] args) {
		launchApp(EsguiApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(windowTitle);

		initRootLayout();

		showIndex();

		// 窗口关闭事件
		primaryStage.setOnCloseRequest(event -> System.out.print("窗口关闭"));
	}

	/**
	 * Initializes the root layout.
	 */
	private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void showIndex() {
		 try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(getClass().getResource("view/Index.fxml"));
	            AnchorPane personOverview = (AnchorPane) loader.load();

	            // Set person overview into the center of root layout.
	            rootLayout.setCenter(personOverview);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
}
