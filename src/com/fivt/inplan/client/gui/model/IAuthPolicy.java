package com.fivt.inplan.client.gui.model;

import com.fivt.inplan.client.pojo.Deanery;
import com.fivt.inplan.client.pojo.Professor;
import com.fivt.inplan.client.pojo.Student;

public interface IAuthPolicy {
	
	Student tryAuthStudent(String login, String password);
	
	Professor tryAuthProfessor(String login, String password);
	
	Deanery tryAuthDeanery(String login, String password);
}
