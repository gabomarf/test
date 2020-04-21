package com.test.test.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Setter;

@Setter
public class Region {
	
	private String fecha;
	
	@JsonSetter("local_id")
	private String localId; 
	
	@JsonSetter("local_nombre")
	private String localNombre; 
	
	@JsonSetter("comuna_nombre")
	private String comunaNombre; 
	
	@JsonSetter("localidad_nombre")
	private String localidadNombre; 
	
	@JsonSetter("local_direccion")
	private String localDireccion;
    
	@JsonSetter("funcionamiento_hora_apertura")
	private String funcionamientoHoraApertura; 
    
	@JsonSetter("funcionamiento_hora_cierre")
	private String funcionamientoHoraCierre;
    
	@JsonSetter("local_telefono")
	private String localTelefono; 
    
	@JsonSetter("local_lat")
	private String localLat; 
    
	@JsonSetter("local_lng")
	private String localLng; 
    
	@JsonSetter("funcionamiento_dia")
	private String funcionamientoDia; 
    
	@JsonSetter("fk_region")
	private Integer idRegion;
    
	@JsonSetter("fk_comuna")
	private Integer idComuna;
	
	

	@JsonIgnore
	public String getLocalId() {
		return localId;
	}

	@JsonGetter("localNombre")
	public String getLocalNombre() {
		return localNombre;
	}

	@JsonIgnore
	public String getComunaNombre() {
		return comunaNombre;
	}

	@JsonIgnore
	public String getLocalidadNombre() {
		return localidadNombre;
	}

	@JsonGetter("localDireccion")
	public String getLocalDireccion() {
		return localDireccion;
	}

	@JsonIgnore
	public String getFuncionamientoHoraApertura() {
		return funcionamientoHoraApertura;
	}

	@JsonIgnore
	public String getFuncionamientoHoraCierre() {
		return funcionamientoHoraCierre;
	}

	@JsonGetter("localTelefono")
	public String getLocalTelefono() {
		return localTelefono;
	}

	@JsonGetter("localLat")
	public String getLocalLat() {
		return localLat;
	}

	@JsonGetter("localLng")
	public String getLocalLng() {
		return localLng;
	}

	@JsonIgnore
	public String getFuncionamientoDia() {
		return funcionamientoDia;
	}

	@JsonIgnore
	public Integer getIdRegion() {
		return idRegion;
	}

	@JsonIgnore
	public Integer getIdComuna() {
		return idComuna;
	}

	@JsonIgnore
	public String getFecha() {
		return fecha;
	} 

}
