package com.wlopera.spring.dominio;

import java.math.BigDecimal;

public class Oferta {

	private BigDecimal precio;
	private Mes mes;
	private TipoHabitacion tipoHab;
	private int minNoches;

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public TipoHabitacion getTipoHab() {
		return tipoHab;
	}

	public void setTipoHab(TipoHabitacion tipoHab) {
		this.tipoHab = tipoHab;
	}

	public int getMinNoches() {
		return minNoches;
	}

	public void setMinNoches(int minNoches) {
		this.minNoches = minNoches;
	}

	public Oferta() {
		// TODO Auto-generated constructor stub
	}

}
