package com.test.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.test.client.ApiRegionDao;
import com.test.test.domain.Region;
import com.test.test.domain.RegionPredicates;
import com.test.test.error.NotFoundException;
import com.test.test.service.IRegionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegionServiceImpl implements IRegionService {
	
	private final ApiRegionDao ApiRegionDaoImpl;
	
	public RegionServiceImpl(ApiRegionDao ApiRegionDaoImpl){
		this.ApiRegionDaoImpl = ApiRegionDaoImpl;
	}

	@Override
	public List<Region> getRegionByRegion(Integer idRegion, String nameComuna) {
		log.debug("Init Serach Region by idRegion: {} or nameComune: {}", idRegion, nameComuna);
		List<Region> lstRegion = this.ApiRegionDaoImpl.getAllRegions().getLstRegion()
				.stream()
				.filter(RegionPredicates.getPredicateSearch(idRegion, nameComuna))
				.collect(Collectors.toList());
		log.debug("Result search: {}",lstRegion.size());
		if(lstRegion == null || lstRegion.isEmpty()) {
			log.debug("return error object not found in the list");
			throw new NotFoundException("Region no encontrado");
		}
		return lstRegion;
	}

	

}
