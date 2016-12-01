package com.fivt.inplan.client.gui.view;

import com.fivt.inplan.client.gui.presenter.AuthPresenter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AuthView {
	
	private AuthPresenter presenter;
	
	@FXML
	private TextField login;
	@FXML
	private TextField password;
	@FXML
	private Button loginButton;
	@FXML
	private RadioButton studentRadio;
	@FXML
	private RadioButton professorRadio;
	@FXML
	private RadioButton deaneryRadio;
	
	public void setPresenter(AuthPresenter presenter) {
		this.presenter = presenter;
	}
	
	@FXML
    private void initialize() {
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if (presenter != null) {
					presenter.onLoginButtonClick();
				}
			}
		});
		
		ToggleGroup group = new ToggleGroup();
		studentRadio.setSelected(true);
		studentRadio.setToggleGroup(group);
		professorRadio.setToggleGroup(group);
		deaneryRadio.setToggleGroup(group);
    }
	
	public String getLogin() {
		return login.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
	
	public boolean isStudent() {
		return studentRadio.isSelected();
	}
	
	public boolean isProfessor() {
		return  professorRadio.isSelected();
	}
	
	public boolean isDeanery() {
		return deaneryRadio.isSelected();
	}
}
