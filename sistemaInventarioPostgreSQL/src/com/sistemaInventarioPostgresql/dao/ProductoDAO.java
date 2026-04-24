package com.sistemaInventarioPostgresql.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.sistemaInventarioPostgresql.config.DataBaseConnection;
import com.sistemaInventarioPostgresql.model.Producto;

public class ProductoDAO {

	private Connection conexion;
	
	

	public ProductoDAO() {
		this.conexion = DataBaseConnection.getConexion();
	}
	
	//REGISTRA
	public boolean registrarProducto(Producto producto) {
		
		String sql = "INSERT INTO productos (codigo_producto, nombre, precio, stock, categoria, fecha_registro ) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexion.prepareStatement(sql)	){
			
			
			ps.setString(1, producto.getCodigoProducto());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getCategoria());
            ps.setDate(6, Date.valueOf(producto.getFechaRegistro()));
            
            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//LISTAR
	public List<Producto> listarProducto(){
		
		List<Producto> lista = new ArrayList<>();
		String sql = "SELECT id, codigo_producto, nombre, precio, stock, categoria, fecha_registro FROM productos";
		 
		try(PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery() ) {
			 
			 
			 while(rs.next()) {
				 Producto p = new Producto();
				 
				 p.setId(rs.getInt("id"));
				 p.setCodigoProducto(rs.getString("codigo_producto"));
				 p.setNombre(rs.getString("nombre"));
				 p.setPrecio(rs.getDouble("precio"));
				 p.setStock(rs.getInt("stock"));
				 p.setCategoria(rs.getString("categoria"));
				 p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
				 lista.add(p);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	//BUSCAR
	public Producto buscarProducto(String codigoProducto) {
		
		String sql = "SELECT * FROM productos WHERE codigo_producto = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, codigoProducto);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Producto producto = new Producto();
				
				producto.setId(rs.getInt("id"));
				producto.setCodigoProducto(rs.getString("codigo_producto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
				
				return producto;
			}
			
		} catch (Exception e) {
			System.out.println("Error al buscar: " + e.getMessage());
		}
		return null;
	}
	
	
	//ACTUALIZAR
	public boolean actualizarProducto(String codigoProducto, String nombre, double precio, int stock, String categoria) {
		
		String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ?, categoria = ? WHERE codigo_producto = ?";
		
		try (PreparedStatement ps = conexion.prepareStatement(sql)	){
			
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, stock);
            ps.setString(4, categoria);
            ps.setString(5, codigoProducto);
			
            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
			
		} catch (Exception e) {
			System.err.println("Error al actualizar producto: " + e.getMessage());
		}
		return false;
	}
	
	
	//ELIMINAR
	public boolean eliminarProducto(String codigoProducto) {
		
		String sql = "DELETE FROM productos WHERE codigo_producto = ?";
		
		try (PreparedStatement ps = conexion.prepareStatement(sql)){
			
			ps.setString(1, codigoProducto);

			int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
			
			
		} catch (Exception e) {
			System.err.println("Error al eliminar: " + e.getMessage());
		}
		
		return false;
	}
	
	
	//PRODUCTOS BAJOS EN STOCK
	public List<Producto> productoBajoStock() {
		
		List<Producto> lista = new ArrayList<>();
		String sql = "SELECT * FROM productos WHERE stock < 5";
		
		try(PreparedStatement ps = conexion.prepareStatement(sql);
				ResultSet rs = ps.executeQuery() ) {
				 
				 
				 while(rs.next()) {
					 Producto p = new Producto();
					 
					 p.setId(rs.getInt("id"));
					 p.setCodigoProducto(rs.getString("codigo_producto"));
					 p.setNombre(rs.getString("nombre"));
					 p.setPrecio(rs.getDouble("precio"));
					 p.setStock(rs.getInt("stock"));
					 p.setCategoria(rs.getString("categoria"));
					 p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
					 lista.add(p);
				 }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return lista;
	}
}
