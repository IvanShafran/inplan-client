package com.fivt.inplan.client.gui.view;

import com.fivt.inplan.client.gui.model.StudentRatingModel.CourseItem;
import com.fivt.inplan.client.gui.model.StudentRatingModel.MarkItem;
import com.fivt.inplan.client.gui.presenter.StudentRatingPresenter;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentRatingView {
	@FXML
	private TableView<CourseItem> courseTable;
	
	@FXML
	private TableColumn<CourseItem, String> courseColumn;
	
	@FXML
	private TableColumn<CourseItem, Double> averageMarkColumn;
	
	@FXML
	private TableView<MarkItem> markTable;
	
	@FXML
	private TableColumn<MarkItem, Integer> valueColumn;
	
	@FXML
	private TableColumn<MarkItem, String> descriptionColumn;
	
	@FXML
	private void initialize() {
		courseColumn.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
		averageMarkColumn.setCellValueFactory(cellData -> cellData.getValue().averageMarkProperty().asObject());
		
		valueColumn.setCellValueFactory(cellData -> cellData.getValue().valueProperty().asObject());
		descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		
		courseTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (presenter != null) 
						presenter.onCourseClick(newValue.getCourseId());
					});
	}
	
	private StudentRatingPresenter presenter;
	
	public void setPresenter(StudentRatingPresenter presenter) {
		this.presenter = presenter;
	}
	
	public void setCourses(ObservableList<CourseItem> courses) {
		courseTable.setItems(courses);
	}
	
	public void setMarks(ObservableList<MarkItem> marks) {
		markTable.setItems(marks);
	}
}
