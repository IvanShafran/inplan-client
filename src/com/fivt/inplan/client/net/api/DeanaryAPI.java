package com.fivt.inplan.client.net.api;

import java.util.List;

import com.fivt.inplan.client.pojo.Deanery;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DeanaryAPI {
	
	String BASE_DEANERIES = "/deaneries";

	@GET(BASE_DEANERIES + "/all")
	Call<List<Deanery>> getAllDeaneries();
	
	@GET(BASE_DEANERIES + "/all/id")
	Call<List<Long>> getAllDeaneriesIds();
	
	@GET(BASE_DEANERIES + "/label/{label}")
	Call<List<Deanery>> getDeneariesByLabel(@Path("label") String label);
	
	@GET(BASE_DEANERIES + "/label/id/{label}")
	Call<List<Long>> getDeneariesIdsByLabel(@Path("label") String label);
	
	@GET(BASE_DEANERIES + "/id/{id}")
	Call<Deanery> getDeaneryById(@Path("id") Long deaneryId);
}
