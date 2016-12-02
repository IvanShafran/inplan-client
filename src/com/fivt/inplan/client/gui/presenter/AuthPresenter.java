package com.fivt.inplan.client.gui.presenter;

import com.fivt.inplan.client.Logger;
import com.fivt.inplan.client.gui.model.ExistAuthPolicy;
import com.fivt.inplan.client.gui.view.AuthView;
import com.fivt.inplan.client.pojo.Deanery;
import com.fivt.inplan.client.pojo.Professor;
import com.fivt.inplan.client.pojo.Student;

import javafx.stage.Stage;

public class AuthPresenter extends WindowPresenter<AuthView> {
	
	private static final String TAG = AuthPresenter.class.getSimpleName();
	
	private static final String AUTH_VIEW = "AuthView.fxml";
	private static final String TITLE = "Auth";
	
	public static void start(Stage primaryStage) {
		WindowPresenter<AuthView> presenter = new AuthPresenter(primaryStage);
		presenter.show();
	}
	
	private AuthPresenter(Stage primaryStage) {
		super(primaryStage, AUTH_VIEW);
		setTitle(TITLE);
		view.setPresenter(this);
	}
	
	public void onLoginButtonClick() {
		ExistAuthPolicy authPolicy = new ExistAuthPolicy();
		
		String login = view.getLogin();
		String password = view.getPassword();
		
		if (view.isStudent()) {
			Student student = authPolicy.tryAuthStudent(login, password);
			if (student != null) {
				Logger.d(TAG, "auth: success");
				StudentMainPresenter.start(student);
				hide();
			}
		} else if (view.isProfessor()) {
			Professor professor = authPolicy.tryAuthProfessor(login, password);
			if (professor != null) {
				Logger.d(TAG, "auth: success");
				//start
			}
		} else if (view.isDeanery()) {
			Deanery deanery = authPolicy.tryAuthDeanery(login, password);
			if (deanery != null) {
				Logger.d(TAG, "auth: success");
				//start
			}
		} else {
			Logger.d(TAG, "auth: fail");
		}
	}
}
