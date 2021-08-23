package com.example.prueba;

public class GeoConsultResponse {

	private String pais;
	private String description;
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return pais+description;
		
	}
	
}
