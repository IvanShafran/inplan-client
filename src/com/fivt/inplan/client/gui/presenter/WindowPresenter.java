package com.fivt.inplan.client.gui.presenter;

import java.io.IOException;

import com.fivt.inplan.client.Client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WindowPresenter {
	
	private static final String ROOT_LAYOUT = "RootLayout.fxml";
	
	protected Stage stage;
	protected Scene scene;
	protected BorderPane rootLayout;
	
	public static WindowPresenter from(String viewPath) {
		return from(viewPath, null);
	}
	
	/**
	 * Creates WindowPresenter with one stage and scene from viewPath.
	 * @param viewPath -- relative to Client folder
	 * @return null if viewPath is wrong
	 */
	public static WindowPresenter from(String viewPath, Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Client.class.getResource(ROOT_LAYOUT));
			BorderPane rootLayout = (BorderPane) loader.load();
			
			loader.setLocation(Client.class.getResource(viewPath));
			AnchorPane pane = (AnchorPane) loader.load();
			rootLayout.setCenter(pane);
			
			return new WindowPresenter(rootLayout, stage);
		} catch (IOException e) {
			return null;
		}
	}
	
	private WindowPresenter(BorderPane rootLayout, Stage stage) {
		this.rootLayout = rootLayout;
		
		scene = new Scene(rootLayout);
		
		if (stage == null) {
			stage = new Stage();
		}
		
		this.stage = stage;
		stage.setScene(scene);
	}
	
	public void show() {
		stage.show();
	}
	
	/**
	 * When all stage become hidden, app will close
	 */
	public void hide() {
		stage.hide();
	}
	
	public void setTitle(String title) {
		stage.setTitle(title);
	}
	
}
