package com.fivt.inplan.client.gui.view;

import com.fivt.inplan.client.gui.model.ProfessorModel.CourseItem;
import com.fivt.inplan.client.gui.model.ProfessorModel.StudentItem;
import com.fivt.inplan.client.gui.presenter.ProfessorPresenter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ProfessorView {
	@FXML
	private TableView<CourseItem> courseTable;
	
	@FXML
	private TableColumn<CourseItem, String> courseColumn;
	
	@FXML
	private TableView<StudentItem> studentTable;
	
	@FXML
	private TableColumn<StudentItem, String> studentColumn;
	
	@FXML
	private Button button;
	
	private ProfessorPresenter presenter;
	
	@FXML
	private void initialize() {
		courseColumn.setCellValueFactory(cellData -> cellData.getValue().labelProperty());
		
		studentColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
		courseTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (presenter != null) {
						if (newValue != null) {
							presenter.onCourseClick(newValue.getId());
						}
					}
					});
		
		studentTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (presenter != null) {
						if (newValue != null) {
							presenter.onStudentClick(newValue.getId());
						}
					}
					});
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (presenter != null) {
					Long courseId = null;
					CourseItem item = courseTable.getSelectionModel().selectedItemProperty().get();
					if (item != null) {
						courseId = item.getId();
					}
					
					presenter.onPutMarksClick(courseId);
				}
			}
		});
	}
	
	public void setPresenter(ProfessorPresenter presenter) {
		this.presenter = presenter;
	}
	
	public void setCourses(ObservableList<CourseItem> items) {
		courseTable.setItems(items);
	}
	
	public void setStudents(ObservableList<StudentItem> items) {
		studentTable.setItems(items);
	}
}
