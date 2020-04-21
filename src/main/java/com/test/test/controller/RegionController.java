package com.test.test.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.config.EndPoint;
import com.test.test.domain.ListRegion;
import com.test.test.error.ErrorResponse;
import com.test.test.service.IRegionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(EndPoint.V1 + EndPoint.API + EndPoint.REGION)
@Api(value = "Region ", description = "Operations that get Region")
public class RegionController {

	private final IRegionService regionService;

	RegionController(IRegionService regionService) {
		this.regionService = regionService;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "View a list of available products", response = ListRegion.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list", response = ListRegion.class),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "System error", response = ErrorResponse.class)})
	public ResponseEntity<?> getAll(@RequestParam(value = "idRegion", required = false) Integer idRegion, 
			@RequestParam(value = "comuna", required = false) String nameComune) {
		return ResponseEntity.ok().body(this.regionService.getRegionByRegion(idRegion, nameComune));
	}
}
