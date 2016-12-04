package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Mark;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MarkApi {
	
	String BASE_MARK = "/marks";
	
	@GET(BASE_MARK + "/student/{student}")
	Call<List<Mark>> getMarksByStudentId(@Path("student") Long studentId);
	
	@GET(BASE_MARK + "/professor/{professor}")
	Call<List<Mark>> getMarksByProfessorId(@Path("professor") Long professorId);
	
	@GET(BASE_MARK + "/course/{course}")
	Call<List<Mark>> getMarksByCourseId(@Path("course") Long courseId);
	
	@GET(BASE_MARK + "/id/{id}")
	Call<Mark> getMarkById(@Path("id") Long markId);
	
	@PUT(BASE_MARK + "/id/{id}")
	Call<Void> updateMarkById(@Path("id") Long markId, @Body RequestBody markBody);
	
	@POST(BASE_MARK)
	Call<Void> createMark(@Body Mark mark);
	
	@DELETE(BASE_MARK + "/id/{id}")
	Call<Void> deleteMarkById(@Path("id") Long markId);
}
