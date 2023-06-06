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

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ListaServicio listaServicios;

    @Autowired
    private Servicio servicio;
    
    @ModelAttribute("diasSemana")
    public List<String> getDiasSemana() {
        return Arrays.asList("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sebado");
    }
    
 // Mostrar la lista de servicios
    @GetMapping("/listado")
    public String getListaServiciosPage(Model model) {
        model.addAttribute("servicios", listaServicios.getServicios());
        return "servicios";
    }
 // Mostrar formulario para nuevo servicio
    @GetMapping("/nuevo")
    public String getNuevoServicioPage(Model model) {
        boolean edicion = false;
        model.addAttribute("servicio", servicio);
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
		listaServicios.getServicios().add(servicio);
		modelView.setViewName("redirect:/servicios/listado");
		modelView.addObject("servicios", listaServicios.getServicios());
		return modelView;
	}

 // Mostrar formulario para modificar servicio
    @GetMapping("/modificar/{id}")
    public String getModificarServicioPage(Model model, @PathVariable(value = "id") Long id) {
        Servicio servicioEncontrado = null;
        boolean edicion = true;
        for (Servicio serv : listaServicios.getServicios()) {
            if (serv.getId() == id) {
                servicioEncontrado = serv;
                break;
            }
        }
        if (servicioEncontrado == null) {
            // Manejar el caso si no se encuentra el servicio
            return "redirect:/servicios/listado";
        }
        model.addAttribute("servicio", servicioEncontrado);
        model.addAttribute("edicion", edicion);
        return "nuevo_servicio";
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

        for (Servicio serv : listaServicios.getServicios()) {
            if (serv.getId() == servicio.getId()) {
                serv.setNombre(servicio.getNombre());
                serv.setHoraInicio(servicio.getHoraInicio());
                serv.setHoraFin(servicio.getHoraFin());
                serv.setDia(servicio.getDia());
                break;
            }
        }

        return "redirect:/servicios/listado";
    }

 // Eliminar servicio
    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable(value = "id") Long id) {
        for (Servicio serv : listaServicios.getServicios()) {
            if (serv.getId() == id) {
                listaServicios.getServicios().remove(serv);
                break;
            }
        }
        return "redirect:/servicios/listado";
    }
}