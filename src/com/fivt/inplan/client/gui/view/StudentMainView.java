package com.fivt.inplan.client.gui.view;

import com.fivt.inplan.client.gui.presenter.StudentMainPresenter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StudentMainView {
	
	@FXML
	private Button button;
	
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
	}
	
	public void setPresenter(StudentMainPresenter presenter) {
		this.presenter = presenter;
	}
	
}
