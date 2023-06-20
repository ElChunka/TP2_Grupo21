package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaNuevoProducto;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
	@Autowired
	private Producto producto;
	
	@Autowired
	private ListaNuevoProducto listaProducto;
	
	@Override
	public List<Producto> getProductos() {
	return listaProducto.getProductos();
	}
	
	@Override
	public Producto getProducto() {
	return this.producto;
	}

	@Override
	public void guardar(Producto producto) {
	listaProducto.getProductos().add(producto);
	}

	@Override
	public Producto getBy(int codigo) {
		Producto productoEncontrado = new Producto();
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getCodigo()== codigo) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}

	@Override
	public void modificar(Producto productoModificado) {
	    for (Producto prod : listaProducto.getProductos()) {
	        if (prod.getCodigo() == productoModificado.getCodigo()) {
	            prod.setNombre(productoModificado.getNombre());
	            prod.setCodigo(productoModificado.getCodigo());
	            prod.setCategoria(productoModificado.getCategoria());
	            prod.setPrecio(productoModificado.getPrecio());
	            prod.setDescuento(productoModificado.getDescuento());
	            break;
	        }
	    }
	}

	@Override
	public void eliminar(Producto productoEliminar) {
		listaProducto.getProductos().remove(productoEliminar);

	}


	
}
