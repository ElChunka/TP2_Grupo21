package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {
	
	List<Servicio> getServicios();
	Servicio getServicio();
	void guardar(Servicio servicio);
	void listar();
	void modificar(Servicio servicio);
	void eliminar(Servicio servicio);
	boolean buscar(Long id);
	Servicio recuperar(Long id);
}
