package com.fivt.inplan.client.gui.model;

import java.io.IOException;
import java.util.List;

import com.fivt.inplan.client.Client;
import com.fivt.inplan.client.pojo.Deanery;
import com.fivt.inplan.client.pojo.Professor;
import com.fivt.inplan.client.pojo.Student;
import com.fivt.inplan.client.pojo.User;

public class ExistAuthPolicy implements IAuthPolicy {
	
	private <T extends User> T tryAuth(List<T> users, String login) {
		for (T user : users) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
	
		return null;
	}
	
	public Deanery tryAuthDeanery(String login, String password) {
		try {
			List<Deanery> deaneries = 
					Client.deaneryApi.getAllDeaneries().execute().body();
			
			return tryAuth(deaneries, login);
		} catch (IOException e) {
			return null;
		}
	}
	
	public Professor tryAuthProfessor(String login, String password) {
		try {
			List<Professor> professors = 
					Client.professorApi.getAllProfessors().execute().body();
			
			return tryAuth(professors, login);
		} catch (IOException e) {
			return null;
		}
	}
	
	public Student tryAuthStudent(String login, String password) {
		try {
			List<Student> students = 
					Client.studentApi.getAllStudents().execute().body();
			
			return tryAuth(students, login);
		} catch (IOException e) {
			return null;
		}
	}
}
