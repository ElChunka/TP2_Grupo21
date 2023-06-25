package ar.edu.unju.fi.listas;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

@Component
public class ListaNuevoProducto {

	private List<Producto> Productos;
	
	public ListaNuevoProducto() {

	}
	public List<Producto> getProductos(){
		return Productos;
	}
	
	public void setproducto(List<Producto> producto) {
		this.Productos = producto;
	}
} 
