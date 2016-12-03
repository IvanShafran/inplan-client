package com.fivt.inplan.client.gui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fivt.inplan.client.Client;
import com.fivt.inplan.client.pojo.Course;
import com.fivt.inplan.client.pojo.Mark;
import com.fivt.inplan.client.pojo.Student;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import retrofit2.Call;
import retrofit2.Response;

public class StudentRatingModel {
	
	private Student student;
	private List<Mark> marks;
	private List<Course> courses;
	private List<CourseItem> courseItems;
	private Map<Long, List<Mark>> courseMarks;
	
	public StudentRatingModel(Student student) {
		this.student = student;
	}
	
	private void loadMarks() {
		Call<List<Mark>> call = Client.markApi.getMarksByStudentId(student.getId());
		try {
			marks = call.execute().body();
		} catch (IOException e) {
			marks = Collections.emptyList();
		}
	}
	
	private void loadCourses() {
		courses = new ArrayList<>();
		//У студента и его плана совпадают id
		Call<List<Long>> call = Client.planApi.getCoursesByPlanId(student.getId());
		try {
			Response<List<Long>> response = call.execute();
			List<Long> coursesIds = response.body();
			
			for (Long courseId : coursesIds) {
				Call<Course> courseCall = Client.courseApi.getCourseById(courseId);
				courses.add(courseCall.execute().body());
			}
		} catch (IOException e) {
			courses = Collections.emptyList();
		}
	}
	
	private void computeCourseItems() {
		courseItems = new ArrayList<>();
		courseMarks = new HashMap<>();
		for (int i = 0; i < courses.size(); ++i) {
			Course course = courses.get(i);
			CourseItem item = new CourseItem();
			item.setCourseId(course.getId());
			item.setCourseName(course.getLabel());
			courseItems.add(item);
			courseMarks.put(course.getId(), new ArrayList<Mark>());
		}
		
		for (Mark mark : marks) {
			courseMarks.get(mark.getCourse()).add(mark);
		}
		
		for (CourseItem item : courseItems) {
			double average = 0;
			
			List<Mark> marks = courseMarks.get(item.getCourseId());
			for (Mark mark : marks) {
				average += mark.getValue();
			}
			
			int size = marks.size();
			item.setAverageMark(average / (size == 0 ? 1 : size));
		}
	}
	
	public List<CourseItem> getCourseItems() {
		if (courseItems != null) {
			return courseItems;
		}
		
		if (marks == null) {
			loadMarks();
		}
		
		if (courses == null) {
			loadCourses();
		}
		
		if (marks == null || courses == null) {
			return Collections.emptyList();
		}
		
		computeCourseItems();
		
		return courseItems;
	}
	
	public List<MarkItem> getCourseMarks(Long courseId) {
		List<MarkItem> items = new ArrayList<>();
		for (Mark mark : courseMarks.get(courseId)) {
			MarkItem item = new MarkItem();
			item.setValue(mark.getValue());
			item.setDescription(mark.getDescription());
			items.add(item);
		}
		
		return items;
	}
	
	public static class CourseItem {
		private StringProperty courseName = new SimpleStringProperty();
		private Long courseId;
		private DoubleProperty averageMark = new SimpleDoubleProperty();
		
		public String getCourseName() {
			return courseName.get();
		}
		
		public void setCourseName(String courseName) {
			this.courseName.set(courseName);
		}
		
		public StringProperty courseNameProperty() {
			return courseName;
		}
		
		public Long getCourseId() {
			return courseId;
		}
		
		public void setCourseId(Long courseId) {
			this.courseId = courseId;
		}
		
		public double getAverageMark() {
			return averageMark.get();
		}
		
		public void setAverageMark(double averageMark) {
			this.averageMark.set(averageMark);
		}
		
		public DoubleProperty averageMarkProperty() {
			return averageMark;
		}
	}
	
	public static class MarkItem {
		private IntegerProperty value = new SimpleIntegerProperty();
		private StringProperty description = new SimpleStringProperty();
		
		public IntegerProperty valueProperty() {
			return value;
		}
		
		public void setValue(Integer value) {
			this.value.set(value);
		}

		public StringProperty descriptionProperty() {
			return description;
		}

		public void setDescription(String description) {
			this.description.set(description);
		}
	}
}
