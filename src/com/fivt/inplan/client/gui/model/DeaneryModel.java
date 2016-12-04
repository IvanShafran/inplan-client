package com.fivt.inplan.client.gui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fivt.inplan.client.Client;
import com.fivt.inplan.client.pojo.Specialization;
import com.fivt.inplan.client.pojo.Student;
import com.fivt.inplan.client.utils.Logger;
import com.fivt.inplan.client.utils.StringUtils;
import com.fivt.inplan.client.utils.StudentUtils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import retrofit2.Call;
import retrofit2.Response;

public class DeaneryModel {
	
	private List<SpecializationItem> specializationItems;
	private List<Specialization> specializations;
	private Map<Long, List<StudentItem>> specializationStudents;
	
	public DeaneryModel() {
		loadSpecializations();
		loadStudents();
	}
	
	private void loadSpecializations() {
		specializationItems = new ArrayList<>();
		specializationStudents = new HashMap<>();
		
		Call<List<Specialization>> call = Client.specializationApi.getAllSpecializations();
		try {
			specializations = call.execute().body();
			for (Specialization specialization : specializations) {
				SpecializationItem item = new SpecializationItem();
				item.setId(specialization.getId());
				item.setLabel(specialization.getLabel());
				specializationItems.add(item);
				specializationStudents.put(specialization.getId(), new ArrayList<DeaneryModel.StudentItem>());
			}
		} catch (IOException e) {
			specializations = Collections.emptyList();
		}
	}
	
	private void loadStudents() {
		for (Specialization specialization : specializations) {
			Call<List<Long>> call = Client.planApi
					.getPlanIdsBySpecialization(specialization.getId());
			try {
				//У студентов и их планов id совпадают
				List<Long> studentIds = call.execute().body();
				for (Long id : studentIds) {
					Call<Student> studentCall = Client.studentApi.getStudentById(id);
					Response<Student> response = studentCall.execute();
					Student student = response.body();
					StudentItem item = new StudentItem();
					item.setId(id);
					item.setName(StudentUtils.getName(student));
					specializationStudents.get(specialization.getId()).add(item);
				}
			} catch (IOException e) {
				//do nothing
			}
		}
	}
	
	public List<SpecializationItem> getSpecializations() {
		return specializationItems;
	}
	
	public List<StudentItem> getStudents(Long specializationId) {
		return specializationStudents.get(specializationId);
	}
	
	public Student getStudent(Long id) {
		Call<Student> call = Client.studentApi.getStudentById(id);
		try {
			return call.execute().body();
		} catch (IOException e) {
			return null;
		}
	}
	
	public static class SpecializationItem {
		private StringProperty label = new SimpleStringProperty();
		private Long id;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}

		public StringProperty labelProperty() {
			return label;
		}

		public void setLabel(String label) {
			this.label.set(label);
		}
	}
	
	public static class StudentItem {
		private StringProperty name = new SimpleStringProperty();
		private Long id;
		
		public StringProperty nameProperty() {
			return name;
		}
		
		public void setName(String name) {
			this.name.set(name);
		}
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
	}
}
