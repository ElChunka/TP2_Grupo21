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

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/consejo")
public class ConsejosController {
		
	//Se crea una nueva lista para los posteos de consejos
	@Autowired
	private ListaConsejo listaConsejos;
	
	@Autowired
	private Consejo consejo;
	
	//Metodo para que la nueva lista obtenga consejos existentes y nuevos
	@GetMapping("/listado")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos",listaConsejos.getConsejos());
		return "consejos";
	}
	
	//Metodo que crea un nuevo objeto y redirige al formulario para un nuevo consejo
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consejo", consejo);
		model.addAttribute("edicion",edicion);
		return "nuevo_consejo";
	}
	
	//Metodo que instancia al nuevo objeto creado anteriormente y lo guarda en la lista de Consejos. verifica que las condiciones se cumplan 
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoConsejoPage(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		ModelAndView modelView = new ModelAndView("consejos");
		if(result.hasErrors()) { //Detección de un error en el formulario de alta
			modelView.setViewName("nuevo_consejo"); // redireccinamiento al html nuevo_consejo
			modelView.addObject("consejo", consejo); // devuelve el objeto consejo
			return modelView;
		}
		listaConsejos.getConsejos().add(consejo);
		modelView.addObject("consejos", listaConsejos.getConsejos());
		return modelView;
	}
	
	//Metodo para capturar el valor por parametro de la url y saber si existe en la lista o no, para su modificacion
	@GetMapping("/modificar/{titulo}")
	public String getModificarConsejoPage(Model model, @PathVariable(value="titulo")String titulo) {
		Consejo consejoEncontrado = new Consejo();
		boolean edicion = true;
		for (Consejo consj : listaConsejos.getConsejos()) {
			if(consj.getTitulo().equals(titulo)) {
				consejoEncontrado = consj;
				break;
			}
		}
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	
	//metodo que modifica uno o mas valores de los atributos del objeto que deseamos 
	@PostMapping("/modificar")
	public String modificarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result, Model model) {
		
		if(result.hasErrors()) { //Detección de un error en el formulario de modificación
			model.addAttribute("edicion", true);
			return "nuevo_consejo";
		}
		
		for(Consejo consj : listaConsejos.getConsejos()) {
			if (consj.getTitulo().equals(consejo.getTitulo())) {
				consj.setPosts(consejo.getPosts());
				consj.setAutor(consejo.getAutor());
			}
		}
	
	return "redirect:/consejo/listado";
	}
	
	
	//metodo que captura el valor por parametro del objeto que vamos a eliminar
	@GetMapping("/eliminar/{titulo}")
	public String eliminarConsejo(@PathVariable(value="titulo")String titulo) {
		for (Consejo consj : listaConsejos.getConsejos()) {
			if(consj.getTitulo().equals(titulo)) {
				listaConsejos.getConsejos().remove(consj);
				break;
			}
		}
		return "redirect:/consejo/listado";
	}
	
}
