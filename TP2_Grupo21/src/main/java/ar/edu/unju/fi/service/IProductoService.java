package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
	//Devuelve la lista de Productos
	List<Producto> getProductos();
	//Listar o Mostrar los productos
	Producto getProducto();
	// Permite guardar los productos 
	void guardar(Producto Producto);
	//Permite realizar la busqueda mediante el codigo
	Producto getBy(Long codigo);
	// Permite modificar los productos
	void modificar (Producto productoModificado);
	// Permite eliminar los productos 
	void eliminar (Producto productoEliminar);
}
