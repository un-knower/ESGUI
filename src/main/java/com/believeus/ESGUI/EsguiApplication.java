package com.believeus.ESGUI;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.believeus.ESGUI.view.IndexView;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;

@SpringBootApplication
public class EsguiApplication extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launchApp(EsguiApplication.class,IndexView.class, args);
	}
	
}
