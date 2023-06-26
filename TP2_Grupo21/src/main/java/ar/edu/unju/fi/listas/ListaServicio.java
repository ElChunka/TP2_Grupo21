package ar.edu.unju.fi.listas;
import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Servicio;

import java.util.ArrayList;
import java.time.LocalTime;


@Component
public class ListaServicio {

	private List<Servicio> servicios;

    public ListaServicio() {
        servicios = new ArrayList<Servicio>();
        // Agregar un ejemplo de servicio a la lista
        /*servicios.add(new Servicio("Facundo Alfaro",10, LocalTime.of(9, 0), LocalTime.of(12, 0), "Lunes" ));
        servicios.add(new Servicio("Facundo Alfaro",20, LocalTime.of(9, 0), LocalTime.of(12, 0), "Martes" ));
        servicios.add(new Servicio("Facundo Alfaro",30, LocalTime.of(9, 0), LocalTime.of(12, 0), "Jueves" ));
        servicios.add(new Servicio("Facundo Alfaro",40, LocalTime.of(9, 0), LocalTime.of(12, 0), "Sabado" ));
        */
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
