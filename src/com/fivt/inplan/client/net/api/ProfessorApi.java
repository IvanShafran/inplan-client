package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Professor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProfessorApi {
	
	String BASE_PROFESSOR = "/professors";
	
	@GET(BASE_PROFESSOR + "/all")
	Call<List<Professor>> getAllProfessors();
	
	@GET(BASE_PROFESSOR + "/all/id")
	Call<List<Long>> getAllProfessorsIds();
	
	@GET(BASE_PROFESSOR + "/lastname/{lastname}")
	Call<List<Professor>> getProfessorsByLastname(@Path("lastname") String lastname);
	
	@GET(BASE_PROFESSOR + "lastname/id/{lastname}")
	Call<List<Long>> getProfessorsIdsByLastname(@Path("lastname") String lastname);
	
	@GET(BASE_PROFESSOR + "/id/{id}")
	Call<Professor> getProfessorById(@Path("id") Long professorId);
}
