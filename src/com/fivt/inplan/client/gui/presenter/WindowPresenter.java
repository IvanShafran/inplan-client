package com.fivt.inplan.client.gui.presenter;

import java.io.IOException;

import com.fivt.inplan.client.Client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WindowPresenter<View> {
	
	private static final String ROOT_LAYOUT = "RootLayout.fxml";
	
	protected Stage stage;
	protected Scene scene;
	protected BorderPane rootLayout;
	
	protected View view;
	
	protected WindowPresenter(Stage stagePrimary, String viewName) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Client.getViewResource(ROOT_LAYOUT));
			rootLayout = (BorderPane) loader.load();
			
			loader = new FXMLLoader();
			loader.setLocation(Client.getViewResource(viewName));
			AnchorPane pane = (AnchorPane) loader.load();
			view = loader.getController();
			rootLayout.setCenter(pane);
		} catch (IOException e) {
			//do nothing
		}
		
		scene = new Scene(rootLayout);
		
		if (stagePrimary == null) {
			stagePrimary = new Stage();
		}
		
		stage = stagePrimary;
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
