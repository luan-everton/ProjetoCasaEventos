package com.GFT.cobranca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;



	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	private String Genero;
	 
	 private String local;;
	 
	 private double lotacao;
	 
	 private String dataEvento;

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public double getLotacao() {
		return lotacao;
	}

	public void setLotacao(double lotacao) {
		this.lotacao = lotacao;
	}

	public String  getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String  dataEvento) {
		this.dataEvento = dataEvento;
	}
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (codigo == null) {
			if (other.codigo!= null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	 
	
}
