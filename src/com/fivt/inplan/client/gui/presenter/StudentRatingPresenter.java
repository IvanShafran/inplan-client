package com.fivt.inplan.client.gui.presenter;

import java.util.List;

import com.fivt.inplan.client.gui.model.StudentRatingModel;
import com.fivt.inplan.client.gui.model.StudentRatingModel.CourseItem;
import com.fivt.inplan.client.gui.model.StudentRatingModel.MarkItem;
import com.fivt.inplan.client.gui.view.StudentRatingView;
import com.fivt.inplan.client.pojo.Student;
import com.fivt.inplan.client.utils.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentRatingPresenter extends WindowPresenter<StudentRatingView> {
	
	private static final String VIEW = "StudentRatingView.fxml";
	
	private Student student;
	private StudentRatingModel model;
	
	public static void start(Student student) {
		WindowPresenter<StudentRatingView> presenter = new StudentRatingPresenter(student);
		presenter.show();
	}
	
	private StudentRatingPresenter(Student student) {
		super(null, VIEW);
		this.student = student;
		
		model = new StudentRatingModel(student);
		
		view.setPresenter(this);
		
		setTitle(student);
		
		List<CourseItem> items = model.getCourseItems();
		ObservableList<CourseItem> observables = FXCollections.observableArrayList();
		observables.addAll(items);
		view.setCourses(observables);
	}
	
	private void setTitle(Student student) {
		String firstName = StringUtils.getNotNullString(student.getFirstname());
		
		String lastName = StringUtils.getNotNullString(student.getLastname());
		
		setTitle(firstName + " " + lastName);
	}
	
	public void onCourseClick(Long courseId) {
		List<MarkItem> items = model.getCourseMarks(courseId);
		ObservableList<MarkItem> observables = FXCollections.observableArrayList();
		observables.addAll(items);
		view.setMarks(observables);
	}
}
