package com.mspark.mongostudy.service;

import com.mspark.mongostudy.domain.mongo.hakryuck.Hakryuck;
import com.mspark.mongostudy.web.model.req.HakryuckRequest;

public interface HakryuckService {

	Hakryuck save(HakryuckRequest request);
	Hakryuck getHakryuck(String userid);
}
