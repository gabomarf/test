package com.test.test.client;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.test.test.domain.ListRegion;
import com.test.test.domain.Region;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiRegionDaoImpl implements ApiRegionDao {

	private final String urlApi;

	private final Integer cantRegion;

	private final RestTemplate restTemplate;

	private final ListRegion lstRegion;

	public ApiRegionDaoImpl(RestTemplate restTemplate, String urlApi, Integer cantRegion) {
		this.restTemplate = restTemplate;
		this.urlApi = urlApi;
		this.cantRegion = cantRegion;
		this.lstRegion = callAllRegions();
	}

	@Override
	public ListRegion callAllRegions() {
		log.info("start Region Load");
		ListRegion lstRegion = new ListRegion();
		lstRegion.setLstRegion(new ArrayList<>());
		for (int i = 1; i <= cantRegion; i++) {
			ResponseEntity<Region[]> regions = this.restTemplate.getForEntity(this.urlApi, Region[].class, i);
			if (regions.getStatusCode().is2xxSuccessful()) {
				lstRegion.getLstRegion().addAll(Arrays.asList(regions.getBody()));
			} else {
				log.error("Error Obteniendo Data de la Api con Región id: %d", i);
			}
		}
		log.info("Data Region Leaded");
		return lstRegion;
	}

	@Override
	public ListRegion getAllRegions() {
		return this.lstRegion;
	}

}
