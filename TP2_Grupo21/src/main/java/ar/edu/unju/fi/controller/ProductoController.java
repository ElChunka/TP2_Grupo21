package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService; 
	
	
	//Metodo para que la nueva lista obtenga productos existentes y nuevos, y mostrarlos en productos.html
	@GetMapping("/listado")
	public String getPagina(Model model) {
		model.addAttribute("productos", productoService.getProductos() );
		return "productos";
	}
	
	//Metodo que crea un nuevo objeto y redirige al formulario para un nuevo producto
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("producto", productoService.getProducto());
		return "nuevo_producto";
	}
	
	//Metodo que crea un nuevo objeto y redirige al formulario para un nuevo producto
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
		ModelAndView modelView = new ModelAndView("redirect:/producto/listado");
		//Detecta un error en el formulario que crea un nuevo producto
		if (result.hasErrors()) {
			modelView.setViewName("nuevo_producto");
			modelView.addObject("producto",producto);
			return modelView;
		}
		productoService.guardar(producto);
		modelView.addObject("producto", productoService.getProductos());
		System.out.println(productoService);
		return modelView;
	}
	
	
	//Metodo para capturar el valor por parametro de la url y saber si existe en la lista o no, para su modificacion
		@GetMapping("/modificar/{codigo}")
		public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
			Producto productoEncontrado = productoService.getBy(codigo);
			boolean edicion = true;
			
			model.addAttribute("producto", productoEncontrado);
			model.addAttribute("edicion", edicion);
			return "nuevo_producto";
		}
		 
		
		//metodo que modifica uno o mas valores de los atributos del objeto que deseamos 
		@PostMapping("/modificar")
		public String modificarProducto(@Valid @ModelAttribute("producto") Producto productoModificado, BindingResult result, Model model) {
		    // Si tienen errores de validación redirige al formulario
		    if (result.hasErrors()) {
		        model.addAttribute("edicion", true);
		        return "nuevo_producto";
		    }
		    productoService.modificar(productoModificado);
		    return "redirect:/producto/listado";
		}
		
		//metodo que captura el valor por parametro del objeto que vamos a eliminar
		@GetMapping("/eliminar/{codigo}")
		public String eliminarConsejo(@PathVariable(value="codigo")int codigo) {
			productoService.eliminar(productoService.getBy(codigo));
			return "redirect:/producto/listado";
		}
}
