package com.fivt.inplan.client.gui.presenter;

import static com.fivt.inplan.client.utils.ObservableUtils.getObservable;

import java.util.List;

import com.fivt.inplan.client.gui.model.DeaneryModel;
import com.fivt.inplan.client.gui.model.DeaneryModel.SpecializationItem;
import com.fivt.inplan.client.gui.model.DeaneryModel.StudentItem;
import com.fivt.inplan.client.gui.view.DeaneryView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeaneryPresenter extends WindowPresenter<DeaneryView> {
	
	private static final String VIEW = "DeaneryView.fxml";
	
	private DeaneryModel model;
	
	public static void start() {
		WindowPresenter<DeaneryView> presenter = new DeaneryPresenter();
		presenter.show();
	}
	
	private DeaneryPresenter() {
		super(null, VIEW);
		
		view.setPresenter(this);
		model = new DeaneryModel();
		
		view.setSpecializations(getObservable(model.getSpecializations()));
	}
	
	public void onSpecializationClick(Long specializationId) {
		view.setStudents(getObservable(model.getStudents(specializationId)));
	}
	
	public void onStudentClick(Long studentId) {
		StudentRatingPresenter.start(model.getStudent(studentId));
	}
}
