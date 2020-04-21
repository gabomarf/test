package com.test.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Setter;

@Setter
public class Region {
	
	@JsonSetter("local_id")
    public String localId; 
	
	@JsonSetter("local_nombre")
    public String localNombre; 
	
	@JsonSetter("comuna_nombre")
    public String comunaNombre; 
	
	@JsonSetter("localidad_nombre")
    public String localidadNombre; 
	
	@JsonSetter("local_direccion")
    public String localDireccion;
    
	@JsonSetter("funcionamiento_hora_apertura")
    public String funcionamientoHoraApertura; 
    
	@JsonSetter("funcionamiento_hora_cierre")
    public String funcionamientoHoraCierre;
    
	@JsonSetter("local_telefono")
    public String localTelefono; 
    
	@JsonSetter("local_lat")
    public String localLat; 
    
	@JsonSetter("local_lng")
    public String localLng; 
    
	@JsonSetter("funcionamiento_dia")
    public String funcionamientoDia; 
    
	@JsonSetter("fk_region")
    public Integer idRegion;
    
	@JsonSetter("fk_comuna")
    public Integer idComuna;

	@JsonIgnore
	public String getLocalId() {
		return localId;
	}

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

	public String getLocalTelefono() {
		return localTelefono;
	}

	public String getLocalLat() {
		return localLat;
	}

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

}
