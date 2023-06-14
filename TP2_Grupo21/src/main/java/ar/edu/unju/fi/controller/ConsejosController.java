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

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejosController {
		
	//Agregar comentario de serive e interfaces sobre consejo, declaraciones
	@Autowired
	private IConsejoService consejoService;
	
	//Metodo para que la nueva lista obtenga consejos existentes y nuevos
	@GetMapping("/listado")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos", consejoService.getConsejos()); //comentar
		return "consejos";
	}
	
	//Metodo que crea un nuevo objeto y redirige al formulario para un nuevo consejo
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consejo", consejoService.getConsejo()); //comentar
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
		consejoService.guardar(consejo); // Guardar el nuevo consejo utilizando el servicio
		modelView.addObject("consejos", consejoService.getConsejos());
		return modelView;
	}
	
	//Metodo para capturar el valor por parametro de la url y saber si existe en la lista o no, para su modificacion
	@GetMapping("/modificar/{titulo}")
	public String getModificarConsejoPage(Model model, @PathVariable(value="titulo")String titulo) {
		boolean edicion = true;
		model.addAttribute("consejo", consejoService.getBy(titulo)); // Obtener el consejo por título y agregarlo al modelo
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
		
		consejoService.modificar(consejo); // Modificar el consejo utilizando el servicio
	
	return "redirect:/consejo/listado";
	}
	
	
	//metodo que captura el valor por parametro del objeto que vamos a eliminar
	@GetMapping("/eliminar/{titulo}")
	public String eliminarConsejo(@PathVariable(value="titulo")String titulo) {
		consejoService.eliminar(consejoService.getBy(titulo));
		return "redirect:/consejo/listado";
	}
	
}
