package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Course;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CourseApi {
	
	@GET("/courses/all")
	Call<List<Course>> getAllCources();
	
	@GET("/courses/all/id")
	Call<List<Long>> getAllCourcesIds();
	
	@GET("/courses/label/{label}")
	Call<List<Course>> getCourcesByLabel(@Path("label") String label);
	
	@GET("/courses/label/id/{label}")
	Call<List<Long>> getCourcesIdsByLabel(@Path("label") String label);
	
	@GET("/courses/studyArea/{studyArea}")
	Call<List<Course>> getCourcesByStudyArea(@Path("studyArea") String studyArea);
	
	@GET("/courses/studyArea/id/{studyArea}")
	Call<List<Long>> getCourcesIdsByStudyArea(@Path("studyArea") String studyArea);
	
	@GET("/courses/professor/{professor}")
	Call<List<Course>> getCourcesByProfessorId(@Path("professor") Long professorId);
	
	@GET("/courses/professor/id/{professor}")
	Call<List<Long>> getCourcesIdsByProfessorId(@Path("professor") Long professorId);
	
	@GET("/courses/id/{id}")
	Call<Course> getCourseById(@Path("id") Long courseId);
}
