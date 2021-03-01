package com.vitaapp.backend.tesis.persistence.entity;


import javax.persistence.EmbeddedId;

public class MensajePictograma {
	@EmbeddedId
	private MensajePictogramaPK id;
	private Integer posicion;
	
	public MensajePictogramaPK getId() {
		return id;
	}
	public void setId(MensajePictogramaPK id) {
		this.id = id;
	}
	
	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	
}