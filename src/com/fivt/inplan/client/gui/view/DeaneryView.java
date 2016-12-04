package com.fivt.inplan.client.gui.view;

import com.fivt.inplan.client.gui.model.DeaneryModel.SpecializationItem;
import com.fivt.inplan.client.gui.model.DeaneryModel.StudentItem;
import com.fivt.inplan.client.gui.model.StudentRatingModel.CourseItem;
import com.fivt.inplan.client.gui.model.StudentRatingModel.MarkItem;
import com.fivt.inplan.client.gui.presenter.DeaneryPresenter;
import com.fivt.inplan.client.gui.presenter.StudentRatingPresenter;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DeaneryView {
	@FXML
	private TableView<SpecializationItem> specializationTable;
	
	@FXML
	private TableColumn<SpecializationItem, String> specializationColumn;
	
	@FXML
	private TableView<StudentItem> studentTable;
	
	@FXML
	private TableColumn<StudentItem, String> studentColumn;
	
	@FXML
	private void initialize() {
		specializationColumn.setCellValueFactory(cellData -> cellData.getValue().labelProperty());
		
		studentColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
		specializationTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (presenter != null) 
						presenter.onSpecializationClick(newValue.getId());
					});
		
		studentTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (presenter != null) {
						if (newValue != null) {
							presenter.onStudentClick(newValue.getId());
						}
					}
					});
	}
	
	private DeaneryPresenter presenter;
	
	public void setPresenter(DeaneryPresenter presenter) {
		this.presenter = presenter;
	}
	
	public void setSpecializations(ObservableList<SpecializationItem> specializations) {
		specializationTable.setItems(specializations);
	}
	
	public void setStudents(ObservableList<StudentItem> students) {
		studentTable.setItems(students);
	}
}
