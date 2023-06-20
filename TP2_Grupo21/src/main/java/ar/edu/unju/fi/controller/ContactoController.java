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

import ar.edu.unju.fi.entity.Mensaje;
import ar.edu.unju.fi.listas.ListaMensajes;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	@Autowired
	ListaMensajes mensajes;
	
	@Autowired
	Mensaje mensaje;
	
	@GetMapping("/formulario")
	public String getPageContacto(Model model) {
	model.addAttribute("mensajes",mensajes.getMensajes());
	model.addAttribute("mensaje", mensaje);
	return "contacto";
	}
	
	@PostMapping("/enviar")
	public ModelAndView getSendContactoPage(@Valid @ModelAttribute("mensaje")Mensaje mensaje, BindingResult result) {
		ModelAndView modelView = new ModelAndView("redirect:/contacto/formulario");
		if(result.hasErrors()) {
			modelView.setViewName("contacto");
			modelView.addObject("mensajes", mensajes.getMensajes());
			modelView.addObject("mensaje", mensaje);
			return modelView;
		}
		mensajes.getMensajes().add(mensaje);
		modelView.addObject("mensajes", mensajes.getMensajes());
		return modelView;
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String deleteMensaje(@PathVariable(value="codigo")int codigo) {
		for (Mensaje mens : mensajes.getMensajes()) {
			if(mens.getCod()== codigo) {
				mensajes.getMensajes().remove(mens);
				break;
			}
		}
		return "redirect:/contacto/formulario";
	}
	
	
}