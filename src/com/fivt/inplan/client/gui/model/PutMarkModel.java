package com.fivt.inplan.client.gui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fivt.inplan.client.Client;
import com.fivt.inplan.client.gui.model.ProfessorModel.StudentItem;
import com.fivt.inplan.client.pojo.Mark;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import retrofit2.Call;
import retrofit2.Response;

public class PutMarkModel {
	
	private List<PutMarkItem> putMarkItems;
	
	public PutMarkModel(List<StudentItem> studentItems) {
		putMarkItems = new ArrayList<PutMarkItem>();
		for (StudentItem studentItem : studentItems) {
			PutMarkItem putMarkItem = new PutMarkItem();
			putMarkItem.setStudentId(studentItem.getId());
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
				mark.setStudent(item.getStudentId());
				
				try {
					Call<Void> call = Client.markApi.createMark(mark);
					Response<Void> response = call.execute();
					int t = 1;
				} catch (IOException e) {
					//do nothing
				}
			}
		}
	}
	
	public static class PutMarkItem {
		private StringProperty name = new SimpleStringProperty();
		private Long studentId;
		private IntegerProperty mark = new SimpleIntegerProperty();
		private StringProperty description = new SimpleStringProperty();
		
		public StringProperty nameProperty() {
			return name;
		}
		
		public void setName(StringProperty name) {
			this.name = name;
		}
		
		public Long getStudentId() {
			return studentId;
		}
		
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
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
