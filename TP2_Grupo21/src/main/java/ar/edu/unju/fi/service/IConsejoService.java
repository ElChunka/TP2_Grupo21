package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;

public interface IConsejoService {
	
	List<Consejo> getConsejos();
	
	Consejo getConsejo();
	
	void guardar(Consejo consejoGuardar);
	
	void modificar(Consejo consejoMod);
	
	Consejo getBy(String titulo);
	
	void eliminar(Consejo consejoEliminar);
}
