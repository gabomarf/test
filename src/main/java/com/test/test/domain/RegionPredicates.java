package com.test.test.domain;

import java.util.function.Predicate;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class RegionPredicates {

	 public static Predicate<Region> getPredicateSearch(Integer idRegion, String nameComuna) {
		 if(!StringUtils.isEmpty(nameComuna) && !ObjectUtils.isEmpty(idRegion)) {
			 return region -> region.getIdRegion() == idRegion && nameComuna.equalsIgnoreCase(region.getComunaNombre());
		 }
		 if(StringUtils.isEmpty(nameComuna) && !ObjectUtils.isEmpty(idRegion)) {
			 return region -> region.getIdRegion() == idRegion;   
	    }
		 
		 if(!StringUtils.isEmpty(nameComuna) && ObjectUtils.isEmpty(idRegion)) {
			 return region -> nameComuna.equalsIgnoreCase(region.getComunaNombre());   
	    }
		 
		 return region -> !ObjectUtils.isEmpty(region);
	 }
}
