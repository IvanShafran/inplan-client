package com.fivt.inplan.client.gui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fivt.inplan.client.Client;
import com.fivt.inplan.client.pojo.Course;
import com.fivt.inplan.client.pojo.Professor;
import com.fivt.inplan.client.pojo.Student;
import com.fivt.inplan.client.utils.StudentUtils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import retrofit2.Call;

public class ProfessorModel {
	
	private Professor professor;
	private List<CourseItem> courses;
	private Map<Long, List<StudentItem>> courseStudents; 
	
	public ProfessorModel(Professor professor) {
		this.professor = professor;
		loadCourses();
		loadStudents();
	}
	
	private void loadCourses() {
		Call<List<Course>> call = Client.courseApi
				.getCourcesByProfessorId(professor.getId());
		
		try {
			courses = new ArrayList<CourseItem>();
			List<Course> list = call.execute().body();
			for (Course course : list) {
				CourseItem item = new CourseItem();
				item.setId(course.getId());
				item.setLabel(course.getLabel());
				courses.add(item);
				courseStudents.put(course.getId(), new ArrayList<>());
			}
		} catch (IOException e) {
			courses = Collections.emptyList();
		}
	}
	
	private void loadStudents() {
		for (CourseItem courseItem : courses) {
			Call<List<Long>> call = 
					Client.planApi.getPlanIdsByCourseId(courseItem.getId());
			try {
				List<Long> studentIds = call.execute().body();
				for (Long id : studentIds) {
					Call<Student> studentCall = Client.studentApi.getStudentById(id);
					Student student = studentCall.execute().body();
					StudentItem studentItem = new StudentItem();
					studentItem.setId(student.getId());
					studentItem.setName(StudentUtils.getName(student));
					courseStudents.get(courseItem.getId()).add(studentItem);
				}
			} catch (IOException e) {
				
			}
		}
	}
	
	public Student getStudent(Long studentId) {
		Call<Student> call = Client.studentApi.getStudentById(studentId);
		try {
			return call.execute().body();
		} catch (IOException e) {
			return null;
		}
	}
	
	public List<CourseItem> getCourses() {
		return courses;
	}
	
	public List<StudentItem> getStudents(Long courseId) {
		return courseStudents.get(courseId);
	}
	
	public static class CourseItem {
		private StringProperty label = new SimpleStringProperty();
		private Long id;
		
		public StringProperty labelProperty() {
			return label;
		}
		
		public void setLabel(String label) {
			this.label.set(label);
		}
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
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
