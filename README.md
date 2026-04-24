# Sistema de Inventario con PostgreSQL

Aplicación de consola en Java que permite gestionar 
productos usando una base de datos PostgreSQL.

## Descripción
Sistema CRUD completo que soluciona el problema 
de pérdida de datos al cerrar el programa, 
almacenando los productos de forma permanente 
en una base de datos PostgreSQL.

## Funcionalidades
- Registrar productos
- Listar todos los productos
- Buscar producto por código
- Actualizar producto
- Eliminar producto
- Detectar productos con stock bajo

## Tecnologías usadas
- Java 17
- PostgreSQL
- JDBC (postgresql-42.7.10.jar)
- Programación Orientada a Objetos

## Estructura del proyecto
- model → Clase Producto
- config → DatabaseConnection
- dao → ProductoDAO (CRUD con SQL)
- service → GestorProductos (validaciones)
- principal → Main (menú de consola)

## Base de datos
- Base de datos: db_inventario
- Tabla: productos

## Autor
Ricardo — Estudiante de Desarrollo de Software
Cibertec Perú — 4to ciclo
