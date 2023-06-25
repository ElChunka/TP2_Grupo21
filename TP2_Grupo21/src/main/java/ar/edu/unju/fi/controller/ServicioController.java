package ar.edu.unju.fi.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	@Autowired
	@Qualifier("servicioServiceMysqlImp")
	private IServicioService servicioService;
	
	@Autowired
	@Qualifier("empleadoServiceMysqlImp")
	private IEmpleadoService empleadoService;
	
    
    @ModelAttribute("diasSemana")
    public List<String> getDiasSemana() {
        return Arrays.asList("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado");
    }
    
 // Mostrar la lista de servicios
    @GetMapping("/listado/{dia}")
    public String getListaServiciosPage(Model model, @PathVariable(value = "dia") String dia) {
        model.addAttribute("servicios", servicioService.getServiciosByDay(dia));
        model.addAttribute("dia", dia);
        return "servicios";
    }
    @GetMapping("/listado")
    public String getListaServiciosPage(Model model) {
        model.addAttribute("servicios", servicioService.getServiciosByDay("Lunes"));
        model.addAttribute("dia", "Lunes");
        return "servicios";
    }
 // Mostrar formulario para nuevo servicio
    @GetMapping("/nuevo")
    public String getNuevoServicioPage(Model model) {
        boolean edicion = false;
        model.addAttribute("servicio", servicioService.getServicio());
        model.addAttribute("empleados", empleadoService.getEmpleados());
        model.addAttribute("edicion", edicion);
        return "nuevo_servicio";
    }
    
    @GetMapping("/nuevo_empleado")
    public String getNuevoEmpleadoPage(Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleado());
        return "nuevo_empleado";
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
		servicio.setEstado(true);
		servicioService.guardar(servicio);
		servicioService.listar();
		modelView.setViewName("redirect:/servicios/listado");
		modelView.addObject("servicios", servicioService.getServicios());
		return modelView;
	}
    
    @PostMapping("/guardar_empleado")
	public ModelAndView getGuardarNuevoServicioPage(@ModelAttribute("empleado") Empleado empleado) {
		ModelAndView modelView = new ModelAndView("nuevo_empleado");
		empleado.setEstado(true);
		empleadoService.guardar(empleado);
		modelView.setViewName("redirect:/servicios/nuevo");
		modelView.addObject("empleados", empleadoService.getEmpleados());
		return modelView;
	}

 // Mostrar formulario para modificar servicio
    @GetMapping("/modificar/{id}")
    public String getModificarServicioPage(Model model, @PathVariable(value = "id") Long id) {
        boolean edicion = true;
        if(servicioService.buscar(id)) {
        	model.addAttribute("servicio", servicioService.recuperar(id));
        	model.addAttribute("empleados", empleadoService.getEmpleados());
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
    public String eliminarServicio(@PathVariable(value = "id") Long id) {
        servicioService.eliminar(servicioService.recuperar(id));
        return "redirect:/servicios/listado";
    }
}