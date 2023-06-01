package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaNuevoProducto;
import ar.edu.unju.fi.model.Producto;


@Controller
@RequestMapping("/producto")
public class nuevo_productoController {
	
	@Autowired
	private ListaNuevoProducto listaProducto;

	@Autowired
	private Producto producto;
	
	//Metodo para que la nueva lista obtenga productos existentes y nuevos, y mostrarlos en productos.html
	@GetMapping("/listado")
	public String getPagina(Model model) {
		model.addAttribute("productos", listaProducto.getProductos());
		return "productos";
	}
	
	//Metodo que crea un nuevo objeto y redirige al formulario para un nuevo producto
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("producto", producto);
		return "nuevo_producto";
	}
	
	//Metodo que crea un nuevo objeto y redirige al formulario para un nuevo producto
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoProductoPage(@ModelAttribute("productos") Producto producto) {
		ModelAndView modelView = new ModelAndView("redirect:/producto/listado");
		listaProducto.getProductos().add(producto);
		modelView.addObject("productos", listaProducto.getProductos());
		System.out.println(listaProducto);
		return modelView;
	}
	
	
	//Metodo para capturar el valor por parametro de la url y saber si existe en la lista o no, para su modificacion
		@GetMapping("/modificar/{codigo}")
		public String getModificarConsejoPage(Model model, @PathVariable(value="codigo")int codigo) {
			Producto productoEncontrado = new Producto();
			boolean edicion = true;
			for (Producto prod : listaProducto.getProductos()) {
				if(prod.getCodigo()==codigo) {
					productoEncontrado = prod;
					break;
				}
			}
			model.addAttribute("producto", productoEncontrado);
			model.addAttribute("edicion", edicion);
			return "nuevo_producto";
		}
		
		
		//metodo que modifica uno o mas valores de los atributos del objeto que deseamos 
		@PostMapping("/modificar")
		public String modificarConsejo(@ModelAttribute("producto")Producto producto) {
			for(Producto prod : listaProducto.getProductos()) {
				if (prod.getCodigo()==prod.getCodigo()) {
					prod.setNombre(prod.getNombre());
					prod.setCodigo(prod.getCodigo());
					prod.setCategoria(prod.getCategoria());
					prod.setPrecio(prod.getPrecio());
					prod.setDescuento(prod.getDescuento());
				}
			}
			return "redirect:/producto/listado";
		}
		
		//metodo que captura el valor por parametro del objeto que vamos a eliminar
		@GetMapping("/eliminar/{codigo}")
		public String eliminarConsejo(@PathVariable(value="codigo")int codigo) {
			for (Producto prod : listaProducto.getProductos()) {
				if(prod.getCodigo()== codigo) {
					listaProducto.getProductos().remove(prod);
					break;
				}
			}
			return "redirect:/producto/listado";
		}
}
