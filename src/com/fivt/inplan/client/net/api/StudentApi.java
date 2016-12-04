package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Student;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudentApi {

	String BASE_STUDENT = "/students";
	
	@GET(BASE_STUDENT + "/all")
	Call<List<Student>> getAllStudents();
	
	@GET(BASE_STUDENT + "/all/id")
	Call<List<Long>> getAllStudentsIds();
	
	
	@GET(BASE_STUDENT + "/lastname/{lastname}")
	Call<List<Student>> getStudentsByLastname(@Path("lastname") String lastname);
	
	@GET(BASE_STUDENT + "/lastname/id/{lastname}")
	Call<List<Long>> getStudentsIdsByLastname(@Path("lastname") String lastname);
	
	@GET(BASE_STUDENT + "/id/{id}")
	Call<Student> getStudentById(@Path("id") long studentId);
}
