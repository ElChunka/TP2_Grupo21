package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaNuevoProducto;

import ar.edu.unju.fi.model.Producto;


@Controller
@RequestMapping("/producto")
public class nuevo_productoController {
	
	ListaNuevoProducto listaProducto = new ListaNuevoProducto();

	@GetMapping("/listado")
	public String getPagina(Model model) {
		model.addAttribute("productos", listaProducto.getProductos());
		return "productos";
	}
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("producto", new Producto());
		return "nuevo_producto";
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoProductoPage(@ModelAttribute("productos") Producto producto) {
		ModelAndView modelView = new ModelAndView("productos");
		listaProducto.getProductos().add(producto);
		modelView.addObject("productos", listaProducto.getProductos());
		System.out.println(listaProducto);
		return modelView;
	}
}
