package com.wlopera.spring.dominio;

public class Mes {
	
	private int id;
	private String nombre;
	
	public Mes(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Mes [id=" + id + ", nombre=" + nombre + "]";
	}

}
