package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {
	
	List<Sucursal> getSucursales();
	Sucursal getSucursal();
	void guardar(Sucursal sucursalGuardar);
	void modificar(Sucursal sucursalMod);
	Sucursal getBy(int id);
	void eliminar(Sucursal sucursalEliminar);

}
