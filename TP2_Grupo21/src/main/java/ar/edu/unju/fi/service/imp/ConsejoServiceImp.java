package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;

@Service("consejoServiceImp")
public class ConsejoServiceImp implements IConsejoService{
	@Autowired
	private ListaConsejo listaConsejo; // Lista que almacena los consejos

	@Autowired
	private Consejo consejo; // Objeto Consejo
	
	@Override
	public List<Consejo> getConsejos() {
		return listaConsejo.getConsejos(); // Retorna la lista de consejos almacenada
	}
	
	@Override
	public Consejo getConsejo() {
		return this.consejo; // Retorna el objeto consejo actual
	}

	@Override
	public void guardar(Consejo consejoGuardar) {
		listaConsejo.getConsejos().add(consejoGuardar); // Agrega un nuevo consejo a la lista
	}

	@Override
	public void eliminar(Consejo consejoEliminar) {
		listaConsejo.getConsejos().remove(consejoEliminar); // Elimina un consejo de la lista
	}

	@Override
	public void modificar(Consejo consejoMod) {
		// Busca el consejo por título y actualiza los atributos correspondientes
		for(Consejo consj : listaConsejo.getConsejos()) {
			if (consj.getTitulo().equals(consejoMod.getTitulo())) {
				consj.setPosts(consejoMod.getPosts());
				consj.setAutor(consejoMod.getAutor());
			}
		}
	}

	@Override
	public Consejo getBy(Long id) {
		Consejo consejoBuscado = new Consejo(); // Consejo que se buscará
		for (Consejo consj : listaConsejo.getConsejos()) {
			if(consj.getTitulo().equals(id)) {
				consejoBuscado = consj; // Si se encuentra el consejo con el título especificado, se asigna a la variable consejoBuscado
				break;
			}
		}
		return consejoBuscado; // Retorna el consejo encontrado (o un consejo vacío si no se encuentra)
	}
	
}
