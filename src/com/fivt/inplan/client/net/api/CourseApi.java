package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Course;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CourseApi {
	
	String BASE_COURCES = "/courses";
	
	@GET(BASE_COURCES + "/all")
	Call<List<Course>> getAllCources();
	
	@GET(BASE_COURCES + "/all/id")
	Call<List<Long>> getAllCourcesIds();
	
	@GET(BASE_COURCES + "/label/{label}")
	Call<List<Course>> getCourcesByLabel(@Path("label") String label);
	
	@GET(BASE_COURCES + "/label/id/{label}")
	Call<List<Long>> getCourcesIdsByLabel(@Path("label") String label);
	
	@GET(BASE_COURCES + "/studyArea/{studyArea}")
	Call<List<Course>> getCourcesByStudyArea(@Path("studyArea") String studyArea);
	
	@GET(BASE_COURCES + "/studyArea/id/{studyArea}")
	Call<List<Long>> getCourcesIdsByStudyArea(@Path("studyArea") String studyArea);
	
	@GET(BASE_COURCES + "/professor/{professor}")
	Call<List<Course>> getCourcesByProfessorId(@Path("professor") Long professorId);
	
	@GET(BASE_COURCES + "/professor/id/{professor}")
	Call<List<Long>> getCourcesIdsByProfessorId(@Path("professor") Long professorId);
	
	@GET(BASE_COURCES + "/id/{id}")
	Call<Course> getCourseById(@Path("id") Long courseId);
}
