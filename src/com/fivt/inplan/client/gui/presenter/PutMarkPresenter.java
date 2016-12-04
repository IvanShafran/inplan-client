package com.fivt.inplan.client.gui.presenter;

import java.util.List;

import com.fivt.inplan.client.gui.model.ProfessorModel.StudentItem;
import com.fivt.inplan.client.gui.model.PutMarkModel;
import com.fivt.inplan.client.gui.view.PutMarkView;
import com.fivt.inplan.client.pojo.Professor;
import com.fivt.inplan.client.utils.ObservableUtils;

public class PutMarkPresenter extends WindowPresenter<PutMarkView> {
	
	private static final String VIEW = "PutMarkView.fxml";
	
	private PutMarkModel model;
	private Professor professor;
	private Long courseId;
	
	public static void start(Professor professor, Long courseId,
			List<StudentItem> studentItems) {
		WindowPresenter<PutMarkView> presenter = 
				new PutMarkPresenter(professor, courseId, studentItems);
		presenter.show();
	}
	
	private PutMarkPresenter(Professor professor, Long courseId, 
			List<StudentItem> studentItems) {
		super(null, VIEW);
		
		this.professor = professor;
		this.courseId = courseId;
		
		model = new PutMarkModel(studentItems);
		view.setItems(ObservableUtils.getObservable(model.getPutMarkItems()));
		view.setPresenter(this);
	}
	
	public void onPutMarksClick() {
		model.postNewMarks(courseId, 
				professor.getId(), 
				view.getCommonDescription(), 
				view.getItems());
		hide();
	}
}
