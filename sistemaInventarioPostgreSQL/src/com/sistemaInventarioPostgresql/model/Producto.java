package com.sistemaInventarioPostgresql.model;

import java.time.LocalDate;

public class Producto {

	private int id;
	private String codigoProducto;
	private String nombre;
	private double precio;
	private int stock;
	private String categoria;
	private LocalDate fechaRegistro;
	
	
	public Producto(int id, String codigoProducto, String nombre, double precio, int stock, String categoria,
			LocalDate fechaRegistro) {
		
		this.id = id;
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.fechaRegistro = fechaRegistro;
	}
	
	
	public Producto() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public void mostrarInformacion() {
		System.out.println("ID: " + id);
	    System.out.println("CODIGO	: " + codigoProducto);
	    System.out.println("NOMBRE: " + nombre);
	    System.out.println("PRECIO: " + precio);
	    System.out.println("STOCK: " + stock);
	    System.out.println("CATEGORIA: " + categoria);
	    System.out.println("FECHA DE REGISTRO : " + fechaRegistro);
	}
	
}
