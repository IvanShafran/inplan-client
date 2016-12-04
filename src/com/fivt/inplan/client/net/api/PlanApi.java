package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Plan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlanApi {
	String BASE_PLAN = "/plans";
	
	@GET(BASE_PLAN + "/id/{id}")
	Call<List<Plan>> getPlan(@Path("id") Long studentId);
	
	@GET(BASE_PLAN + "/courses/id/{id}")
	Call<List<Long>> getCoursesByPlanId(@Path("id") Long planId);
		
	@GET(BASE_PLAN + "/specialization/id/{specialization}")
	Call<List<Long>> getPlanIdsBySpecialization(@Path("specialization") Long specializationId);
	
	@GET(BASE_PLAN + "/all/bycourse/{course}")
	Call<List<Long>> getPlanIdsByCourseId(@Path("course") Long courseId);
}
