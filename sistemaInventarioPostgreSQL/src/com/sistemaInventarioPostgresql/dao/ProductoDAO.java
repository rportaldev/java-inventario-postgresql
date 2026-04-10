package com.sistemaInventarioPostgresql.dao;

import java.util.List;
import java.sql.Connection;

import com.sistemaInventarioPostgresql.config.DataBaseConnection;
import com.sistemaInventarioPostgresql.model.Producto;

public class ProductoDAO {

	private Connection conexion;
	

	public ProductoDAO() {
		this.conexion = DataBaseConnection.getConexion();
	}
	
	public boolean registrarProducto(Producto producto) {
		return false;
	}
	
	public List<Producto> listarProducto(){
		return null;
	}
	
	public Producto buscarProducto(String codigoProducto) {
		return null;
	}
	
	public Producto actualizarProducto(String codigoProducto) {
		return null;
	}
	
	public void eliminarProducto(String codigoProducto) {
		
	}
	
	public List<Producto> productoBajoStock() {
		return null;
	}
}
