package ar.edu.unju.fi.listas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;


@Component
public class ListaSucursal {
	private List<Sucursal> sucursales;

    public ListaSucursal() {
        sucursales = new ArrayList<Sucursal>();
        // Agregar un ejemplo de servicio a la lista
        //sucursales.add(new Sucursal("Local 1","Avenida Juan","Tienda de Mascotas", LocalTime.of(9, 0), LocalTime.of(13, 0),"38845310", "ejemplo@gmail.com",10));
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
