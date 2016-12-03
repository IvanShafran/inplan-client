package com.fivt.inplan.client.gui.view;

import com.fivt.inplan.client.gui.presenter.StudentMainPresenter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class StudentMainView {
	
	@FXML
	private Button button;
	
	@FXML
	private ImageView mainView;
	@FXML
	private ImageView rightView;
	
	private StudentMainPresenter presenter;
	
	@FXML
    private void initialize() {
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if (presenter != null) {
					presenter.onShowMarksClick();
				}
			}
		});
		
		ImageLoader.loadImage(R.STUDENT_MAIN_VIEW, mainView);
		ImageLoader.loadImage(R.STUDENT_RIGHT_VIEW, rightView);
	}
	
	public void setPresenter(StudentMainPresenter presenter) {
		this.presenter = presenter;
	}
	
}
