package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;

public interface IConsejoService {
	
	// Retorna una lista de todos los consejos existentes
	List<Consejo> getConsejos();
	
	// Retorna un consejo específico
	Consejo getConsejo();
	
	// Guarda un nuevo consejo
	void guardar(Consejo consejoGuardar);
	
	// Modifica un consejo existente
	void modificar(Consejo consejoMod);
	
	// Retorna un consejo que coincide con un Id
	Consejo getBy(Long id);
	
	// Elimina un consejo existente
	void eliminar(Consejo consejoEliminar);
}
