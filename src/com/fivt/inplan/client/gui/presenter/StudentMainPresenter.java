package com.fivt.inplan.client.gui.presenter;

import java.io.File;
import java.io.IOException;

import com.fivt.inplan.client.Logger;
import com.fivt.inplan.client.gui.view.StudentMainView;
import com.fivt.inplan.client.pojo.Student;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StudentMainPresenter extends WindowPresenter<StudentMainView> {
	
	private static final String TAG = StudentMainPresenter.class.getSimpleName();
	
	private static final String STUDENT_MAIN_VIEW = "StudentMainView.fxml";
	private static final String TITLE = "Student Profile";
	
	private Student student;
	
	public static void start(Student student) {
		WindowPresenter presenter = new StudentMainPresenter(student);
		presenter.show();
	}
	
	private StudentMainPresenter(Student student) {
		super(null, STUDENT_MAIN_VIEW);
		setTitle(TITLE);
		this.student = student;
		this.view.setPresenter(this);
	}
	
	public void onShowMarksClick() {
		Logger.d(TAG, "onClick");
		StudentRatingPresenter.start(student);
	}
}
