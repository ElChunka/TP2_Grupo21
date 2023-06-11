package ar.edu.unju.fi.controller;
import java.util.Arrays;
import java.util.List;

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

import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	@Autowired
	private IServicioService servicioService;
    
    @ModelAttribute("diasSemana")
    public List<String> getDiasSemana() {
        return Arrays.asList("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sebado");
    }
    
 // Mostrar la lista de servicios
    @GetMapping("/listado")
    public String getListaServiciosPage(Model model) {
        model.addAttribute("servicios", servicioService.getServicios());
        return "servicios";
    }
 // Mostrar formulario para nuevo servicio
    @GetMapping("/nuevo")
    public String getNuevoServicioPage(Model model) {
        boolean edicion = false;
        model.addAttribute("servicio", servicioService.getServicio());
        model.addAttribute("edicion", edicion);
        return "nuevo_servicio";
    }

 // Guardar nuevo servicio
    @PostMapping("/guardar")
	public ModelAndView getGuardarNuevoServicioPage(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result) {
		ModelAndView modelView = new ModelAndView("nuevo_servicio");
		if(result.hasErrors()) { //Detección de un error en el formulario de alta
			modelView.setViewName("nuevo_servicio"); // redireccinamiento al html nuevo_consejo
			modelView.addObject("servicio", servicio); // devuelve el objeto consejo
			return modelView;
		}
		servicioService.guardar(servicio);
		servicioService.listar();
		modelView.setViewName("redirect:/servicios/listado");
		modelView.addObject("servicios", servicioService.getServicios());
		return modelView;
	}

 // Mostrar formulario para modificar servicio
    @GetMapping("/modificar/{id}")
    public String getModificarServicioPage(Model model, @PathVariable(value = "id") int id) {
        boolean edicion = true;
        if(servicioService.buscar(id)) {
        	model.addAttribute("servicio", servicioService.recuperar(id));
        	model.addAttribute("edicion", edicion);
        	return "nuevo_servicio";
        }
        else {
        	return "redirect:/servicios/listado";
        }
    }

 // Modificar servicio
    @PostMapping("/modificar")
    public String modificarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result,
            Model model) {
    	// Detecta si hay algun error al modificar 
        if (result.hasErrors()) {
            model.addAttribute("edicion", true);
            return "nuevo_servicio";
        }

        servicioService.modificar(servicio);
        servicioService.listar();

        return "redirect:/servicios/listado";
    }

 // Eliminar servicio
    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable(value = "id") int id) {
        servicioService.eliminar(servicioService.recuperar(id));
        return "redirect:/servicios/listado";
    }
}