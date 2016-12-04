package com.fivt.inplan.client.gui.presenter;

import com.fivt.inplan.client.gui.model.ProfessorModel;
import com.fivt.inplan.client.gui.view.ProfessorView;
import com.fivt.inplan.client.pojo.Professor;

import static com.fivt.inplan.client.utils.ObservableUtils.getObservable;

public class ProfessorPresenter extends WindowPresenter<ProfessorView> {

	private static final String VIEW = "ProfessorView.fxml";
	
	private Professor professor;
	private ProfessorModel model;
	
	public static void start(Professor professor) {
		WindowPresenter<ProfessorView> presenter = new ProfessorPresenter(professor);
		presenter.show();
	}
	
	private ProfessorPresenter(Professor professor) {
		super(null, VIEW);
		
		this.professor = professor;
		model = new ProfessorModel(professor);
		view.setPresenter(this);
		
		view.setCourses(getObservable(model.getCourses()));
	}
	
	public void onCourseClick(Long courseId) {
		view.setStudents(getObservable(model.getStudents(courseId)));
	}
	
	public void onStudentClick(Long studentId) {
		StudentRatingPresenter.start(model.getStudent(studentId));
	}
	
	public void onPutMarksClick(Long courseId) {
		if (courseId != null) {
			PutMarkPresenter.start(professor, courseId,
					model.getStudents(courseId));
		}
	}
}
