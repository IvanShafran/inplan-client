package com.fivt.inplan.client.gui.model;

import java.util.ArrayList;
import java.util.List;

import com.fivt.inplan.client.Client;
import com.fivt.inplan.client.gui.model.ProfessorModel.StudentItem;
import com.fivt.inplan.client.pojo.Mark;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PutMarkModel {
	
	private List<PutMarkItem> putMarkItems;
	
	public PutMarkModel(List<StudentItem> studentItems) {
		putMarkItems = new ArrayList<PutMarkItem>();
		for (StudentItem studentItem : studentItems) {
			PutMarkItem putMarkItem = new PutMarkItem();
			putMarkItem.setId(studentItem.getId());
			putMarkItem.setName(studentItem.nameProperty());
			
			putMarkItems.add(putMarkItem);
		}
	}
	
	public List<PutMarkItem> getPutMarkItems() {
		return putMarkItems;
	}
	
	public void postNewMarks(Long courseId, Long professorId, 
			String commonDescription, 
			List<PutMarkItem> list) {
		for (PutMarkItem item : list) {
			if (item.markProperty().getValue() != 0/*default*/) {
				Mark mark = new Mark();
				mark.setId(null);
				mark.setCourse(courseId);
				mark.setProfessor(professorId);
				mark.setValue(item.mark.get());
				mark.setDescription(commonDescription + " " + item.description.get());
				Client.markApi.createMark(mark);
			}
		}
	}
	
	public static class PutMarkItem {
		private StringProperty name = new SimpleStringProperty();
		private Long id;
		private IntegerProperty mark = new SimpleIntegerProperty();
		private StringProperty description = new SimpleStringProperty();
		
		public StringProperty nameProperty() {
			return name;
		}
		
		public void setName(StringProperty name) {
			this.name = name;
		}
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public IntegerProperty markProperty() {
			return mark;
		}
		
		public void setMark(Integer mark) {
			this.mark.set(mark);
		}

		public StringProperty descriptionProperty() {
			return description;
		}

		public void setDescription(String description) {
			this.description.set(description);
		}
	}
}
