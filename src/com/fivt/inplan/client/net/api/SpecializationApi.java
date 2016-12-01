package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Specialization;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpecializationApi {
	
	String BASE_SPECIALIZATION = "/specializations";
	
	@GET(BASE_SPECIALIZATION + "/all")
	Call<List<Specialization>> getAllSpecializations();
	
	@GET(BASE_SPECIALIZATION + "/all/id")
	Call<List<Long>> getAllSpecializationsIds();
	
	@GET(BASE_SPECIALIZATION + "/label/{label}")
	Call<List<Specialization>> getSpecializationsByLabel(@Path("label") String label);
	
	@GET(BASE_SPECIALIZATION + "/label/id/{label}")
	Call<List<Long>> getSpecializationsIdsByLabel(@Path("label") String label);
	
	@GET(BASE_SPECIALIZATION + "/id/{id}")
	Call<Specialization> getSpecializationById(@Path("id") Long id);
}
