package com.sistemaInventarioPostgresql.principal;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.sistemaInventarioPostgresql.model.Producto;
import com.sistemaInventarioPostgresql.service.GestorProducto;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int opcion;
		
		GestorProducto gestor = new GestorProducto();
		
		
		do {
			System.out.println("\n===== SISTEMA DE PRODUCTOS =====");
			System.out.println();
			System.out.println("1. REGISTRAR PRODUCTO");
			System.out.println("2. MOSTRAR TODOS LOSPRODUCTOS");
			System.out.println("3. BUSCAR PRODUCTO POR SU CODIGO");
			System.out.println("4. ACTUALIZAR PRODUCTO");
			System.out.println("5. ELIMINAR PRODUCTO");
			System.out.println("6. PRODUCTOS BAJO EN STOCK");
			System.out.println("7. ===== SALIR =====");
			System.out.println("Ingrese una opción: ");
			
			if(sc.hasNextInt()) {
				opcion = sc.nextInt();
				sc.nextLine();
			}else {
				System.out.println("Entrada inválida. Por favor, ingrese un número.");
				sc.nextLine();
				opcion = 0;
			}
			
			switch (opcion) {
			case 1: {
				// DATOS DEL PRODUCTO
				System.out.print("Código del producto: ");
				String codigoProducto = sc.nextLine();
				
				
				System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                
                System.out.print("precio: ");
                double precio = sc.nextDouble();
                sc.nextLine(); 
                
                System.out.print("Stock: ");
                int stock = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Categoria: ");
                String categoria = sc.nextLine();
                
                Producto producto = new Producto(0, codigoProducto, nombre, precio, stock, categoria, LocalDate.now());
                
                if(gestor.registrarProducto(producto)) {
                	 System.out.println("✅ Producto registrado exitosamente.");
                }else {
                	System.out.println("❌ Error: código duplicado o stock inválido.");
                }
                break;
                
			}
			
			case 2: {
				//LISTAR PRODUCTOS
				List<Producto> productos = gestor.listarProducto();

				if(productos.isEmpty()) {
				    System.out.println("No hay productos registrados.");
				} else {
				    for(Producto p : productos) {
				        p.mostrarInformacion();
				    }
				}
				
				break;
							
			}
			
			case 3: {
				// PIDE EL CODIGO A BUSCAR
				System.out.print("Ingrese el código del Producto: ");
				String codigoBuscar = sc.nextLine();
				
				Producto encontrado = gestor.buscarProducto(codigoBuscar);
				
				if(encontrado != null) {
					System.out.println("\n===== PRODUCTO ENCONTRADO =====");
					encontrado.mostrarInformacion();
				}else {
					System.out.println("❌ Producto no encontrado.");
				}
				break;
			}
			
			case 4: {
				//ACTUALIZAR PRODUCTO
				System.out.print("Ingrese el código del Producto para ser actualizado: ");
				
				String codigo = sc.nextLine();
				
				System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                
                System.out.print("precio: ");
                double precio = sc.nextDouble();
                sc.nextLine(); 
                
                System.out.print("Stock: ");
                int stock = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Categoria: ");
                String categoria = sc.nextLine();
			
					
				    boolean resultado = gestor.actualizarProducto(codigo, nombre, precio, stock, categoria);
				    if(resultado) {
				        System.out.println("✅ Producto actualizado exitosamente.");
				    } else {
				        System.out.println("❌ Error al actualizar.");
				}
                break;
				
			}
			
			case 5: {
				//ELIMINAR PRODUCTO
				System.out.print("Ingrese el código del Producto a eliminar: ");
                String codigoEliminar = sc.nextLine();
                
                	boolean eliminado = gestor.eliminarProducto(codigoEliminar);
                	
                	if(eliminado) {
                	    System.out.println("✅ Producto eliminado exitosamente.");
                	}else {
                	System.out.println("❌ Producto no encontrado.");
                }
                break;	
			}
			
			case 6: {
				//PRODUCTOS BAJO EN STOCK
				List<Producto> bajoStock = gestor.productoBajoStock();
				
				if(bajoStock.isEmpty()) {
				    System.out.println("✅ No hay productos con stock bajo.");
				} else {
				    for(Producto p : bajoStock) {
				        p.mostrarInformacion();
				    }
				}
				break;
			}
			
			case 7: {
				System.out.println("👋 Saliendo del sistema...");
				break;
		        	
		        }
		        	
			default:
				System.out.println("❌ Opción inválida. Intente de nuevo.");
			}
		} while (opcion != 7);

	}	

}
