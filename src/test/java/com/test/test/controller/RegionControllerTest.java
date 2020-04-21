package com.test.test.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.test.client.ApiRegionDao;
import com.test.test.config.EndPoint;
import com.test.test.domain.ListRegion;
import com.test.test.domain.Region;
import com.test.test.service.IRegionService;
import com.test.test.service.impl.RegionServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class RegionControllerTest {

	@InjectMocks
	private RegionController regionController;

	private MockMvc mockMvc;
	
	@Mock
	private ApiRegionDao apiRegionDao;

	@Mock
	private IRegionService regionService;
	
	@Before
    public void setup() {

		MockitoAnnotations.initMocks(this);
		regionService = new RegionServiceImpl(apiRegionDao);
		regionController = new RegionController(regionService);
        mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();
		
    }
	
	@Test
	public void testGet() throws Exception {
		String comuna = "BUIN";
		ListRegion listRegion = new ListRegion();
		listRegion.setLstRegion(getRefionFromFile());
		when(apiRegionDao.getAllRegions()).thenReturn(listRegion);

		mockMvc.perform(get(EndPoint.V1 + EndPoint.API + EndPoint.REGION + String.format("?comuna=%s",comuna)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$[0].localNombre", is(getRefionFromFile().get(1).getLocalNombre())))
				.andExpect(jsonPath("$[0].localDireccion", is(getRefionFromFile().get(1).getLocalDireccion())))
				.andExpect(jsonPath("$[0].localTelefono", is(getRefionFromFile().get(1).getLocalTelefono())))
				.andExpect(jsonPath("$[0].localLat", is(getRefionFromFile().get(1).getLocalLat())))
				.andExpect(jsonPath("$[0].localLng", is(getRefionFromFile().get(1).getLocalLng())));
	}
	
	private List<Region> getRefionFromFile(){
		ObjectMapper mapper = new ObjectMapper();
		  try {
			return (Arrays.asList(mapper.readValue(new File("src/test/resources/json.json"), Region[].class)));
		} catch (IOException e) {
			e.printStackTrace();
			throw new AssertionError(""); 
		}
	}
	

}
