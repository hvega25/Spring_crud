package com.example.demo.bean;

public class Libro {
	private int id;
	private String autor;
	private String editorial;
	private String fecha;
	private String tematica;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	
	public Libro() {
		super();
		
	}
	public Libro(int id, String autor, String editorial, String fecha, String tematica) {
		super();
		this.id = id;
		this.autor = autor;
		this.editorial = editorial;
		this.fecha = fecha;
		this.tematica = tematica;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", editorial=" + editorial + ", fecha=" + fecha + ", tematica="
				+ tematica + "]";
	}
	
	

}
