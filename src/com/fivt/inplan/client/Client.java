package com.fivt.inplan.client;

import java.net.URL;

import com.fivt.inplan.client.gui.presenter.AuthPresenter;
import com.fivt.inplan.client.net.ServiceGenerator;
import com.fivt.inplan.client.net.api.CourseApi;
import com.fivt.inplan.client.net.api.DeaneryApi;
import com.fivt.inplan.client.net.api.MarkApi;
import com.fivt.inplan.client.net.api.PlanApi;
import com.fivt.inplan.client.net.api.ProfessorApi;
import com.fivt.inplan.client.net.api.SpecializationApi;
import com.fivt.inplan.client.net.api.StudentApi;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {
	
	public static final String BASE_VIEW_PATH = "gui/view/";
	
	public static CourseApi courseApi = ServiceGenerator.createService(CourseApi.class);
	public static DeaneryApi deaneryApi = ServiceGenerator.createService(DeaneryApi.class);
	public static MarkApi markApi = ServiceGenerator.createService(MarkApi.class);
	public static PlanApi planApi = ServiceGenerator.createService(PlanApi.class);
	public static ProfessorApi professorApi = ServiceGenerator.createService(ProfessorApi.class);
	public static SpecializationApi specializationApi = ServiceGenerator.createService(SpecializationApi.class);
	public static StudentApi studentApi = ServiceGenerator.createService(StudentApi.class);
	
	public static URL getViewResource(String viewName) {
		return Client.class.getResource(BASE_VIEW_PATH + viewName);
	}
	
	@Override
	public void start(Stage primaryStage) {
		AuthPresenter.start(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
