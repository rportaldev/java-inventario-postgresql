package com.sistemaInventarioPostgresql.service;

import java.util.List;

import com.sistemaInventarioPostgresql.dao.ProductoDAO;
import com.sistemaInventarioPostgresql.model.Producto;

public class GestorProducto {

	private ProductoDAO productoDAO;

	public GestorProducto() {
		
		this.productoDAO = new ProductoDAO();
	}
	
	//REGISTRAR
	public boolean registrarProducto(Producto producto) {
		
		Producto existe = productoDAO.buscarProducto(producto.getCodigoProducto());

		if(existe !=  null) {
		    return false;
		}
		
		if(producto.getPrecio() < 0) {
		    return false; 
		}

		if(producto.getStock() < 0) {
		    return false; 
		}
		
		return productoDAO.registrarProducto(producto);
	}
	
	
	//LISTAR
	public List<Producto> listarProducto(){
		
		return productoDAO.listarProducto();
	}
	
	
	//BUSCAR PRODUCTO
	public Producto buscarProducto(String codigoProducto) {
		return productoDAO.buscarProducto(codigoProducto);
	}
	
	
	//ACTUALIZAR PRODUCTO
	public boolean actualizarProducto(String codigoProducto, String nombre, double precio, int stock, String categoria) {
		return productoDAO.actualizarProducto(codigoProducto, nombre, precio, stock, categoria);
	}
	
	
	//ELIMINAR
	public boolean eliminarProducto(String codigoProducto) {
		return productoDAO.eliminarProducto(codigoProducto);
	}
	
	
	//PRODUCTOS BAJO EN STOCK
	public List<Producto> productoBajoStock(){
		return productoDAO.productoBajoStock();
	}
}
