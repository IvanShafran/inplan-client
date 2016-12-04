package com.fivt.inplan.client.gui.view;

import com.fivt.inplan.client.gui.model.PutMarkModel.PutMarkItem;
import com.fivt.inplan.client.gui.presenter.PutMarkPresenter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class PutMarkView {
	@FXML
	private TableView<PutMarkItem> table;
	
	@FXML
	private TableColumn<PutMarkItem, String> studentColumn;
	
	@FXML
	private TableColumn<PutMarkItem, Integer> markColumn;
	
	@FXML
	private TableColumn<PutMarkItem, String> descriptionColumn;
	
	@FXML
	private TextArea description;
	
	@FXML
	private Button button;
	
	private PutMarkPresenter presenter;
	
	@FXML
	private void initialize() {
		studentColumn.setCellValueFactory( cellData -> cellData.getValue().nameProperty());
		markColumn.setCellValueFactory( cellData -> cellData.getValue().markProperty().asObject());
		descriptionColumn.setCellValueFactory( cellData -> cellData.getValue().descriptionProperty());
		
		markColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.setEditable(true);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (presenter != null) {
					presenter.onPutMarksClick();
				}
			}
		});
	}
	
	public void setPresenter(PutMarkPresenter presenter) {
		this.presenter = presenter;
	}
	
	public void setItems(ObservableList<PutMarkItem> items) {
		table.setItems(items);
	}
	
	public String getCommonDescription() {
		return description.getText().toString();
	}
	
	public ObservableList<PutMarkItem> getItems() {
		return table.getItems();
	}
}
