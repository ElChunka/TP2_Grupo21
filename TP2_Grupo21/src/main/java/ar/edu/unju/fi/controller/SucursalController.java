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

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired
	private ISucursalService sucursalService;
	
	
	//Metodo para que la nueva lista obtenga sucursales existentes y nuevas
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getSucursales());
		return "sucursales";
	}
	
	//Metodo que crea un nuevo objeto y redirige al formulario para una nueva sucursal
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal", sucursalService.getSucursal());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	//Metodo que instancia al nuevo objeto creado anteriormente y lo guarda en la lista de Sucursales. verifica que las condiciones se cumplan
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevaSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if (result.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
		sucursalService.guardar(sucursal);
		modelView.addObject("sucursales", sucursalService.getSucursales());
		return modelView;
	}
	
	//Metodo para capturar el valor por parametro de la url y saber si existe en la lista o no, para su modificacion
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value = "id") int id) {
		Sucursal sucursalEncontrada = sucursalService.getBy(id);
		boolean edicion = true;
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	//metodo que modifica uno o mas valores de los atributos del objeto que deseamos 
	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result, Model model) {
		if (result.hasErrors()) { //Detección de un error en el formulario de modificación
			model.addAttribute("edicion", true);
			return "nueva_sucursal";
		}
		sucursalService.modificar(sucursal);
		return "redirect:/sucursal/listado";
	}
	
	
	//metodo que captura el valor por parametro del objeto que vamos a eliminar
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value = "id") int id) {
		sucursalService.eliminar(sucursalService.getBy(id));
		return "redirect:/sucursal/listado";
	}
}
