package com.example.prueba;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS_CACHE")
public class PaisCache {
	
	@Id
	@Column(name = "PAIS")
	private String pais;
	@Column(name = "NUMERO")
	private String numero;
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	} 
	
	
	
}

