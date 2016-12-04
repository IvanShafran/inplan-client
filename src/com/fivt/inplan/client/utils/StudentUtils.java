package com.fivt.inplan.client.utils;

import com.fivt.inplan.client.pojo.Student;

public class StudentUtils {
	private StudentUtils() {
		
	}
	
	public static String getName(Student student) {
		return StringUtils.getNotNullString(student.getFirstname())
				+ " " 
				+ StringUtils.getNotNullString(student.getLastname());
	}
}
