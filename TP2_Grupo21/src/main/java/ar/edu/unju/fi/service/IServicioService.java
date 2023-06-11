package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Servicio;

public interface IServicioService {
	
	List<Servicio> getServicios();
	Servicio getServicio();
	void guardar(Servicio servicio);
	void listar();
	void modificar(Servicio servicio);
	void eliminar(Servicio servicio);
	boolean buscar(int id);
	Servicio recuperar(int id);
}