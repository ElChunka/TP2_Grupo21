package ar.edu.unju.fi.listas;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Producto;

public class ListaNuevoProducto {

	private List<Producto> Productos;
	
	public ListaNuevoProducto() {
		Productos= new ArrayList<Producto>();
		Productos.add(new Producto("Correa", "Vestimenta", 30, 1234, 2000, "correa.jpg"));
		Productos.add(new Producto("Cucha", "Cuidado", 30, 4321, 2500, "cucha.jpg"));
		Productos.add(new Producto("Pelota", "Juguete", 30, 2345, 1500, "juguetes.jpg"));
	}
	public List<Producto> getProductos(){
		return Productos;
	}
	
	public void setproducto(List<Producto> producto) {
		this.Productos = producto;
	}
}
