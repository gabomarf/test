package com.test.test.service;

import java.util.List;

import com.test.test.domain.Region;

public interface IRegionService {
	
	public List<Region> getRegionByRegion(Integer idRegion, String nameComuna);
}
