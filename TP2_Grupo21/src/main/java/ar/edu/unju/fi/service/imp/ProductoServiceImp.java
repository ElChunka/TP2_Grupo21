package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private Producto producto;
	
	@Override
	public Producto getProducto() {
	return producto;
	}
	
}
