package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;

@Service
public class ConsejoServiceImp implements IConsejoService{
	@Autowired
	private ListaConsejo listaConsejo;

	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> getConsejos() {
		return listaConsejo.getConsejos();
	}
	
	@Override
	public Consejo getConsejo() {
		return this.consejo;
	}

	@Override
	public void guardar(Consejo consejoGuardar) {
		listaConsejo.getConsejos().add(consejoGuardar);
	}

	@Override
	public void eliminar(Consejo consejoEliminar) {
		listaConsejo.getConsejos().remove(consejoEliminar);
	}

	@Override
	public void modificar(Consejo consejoMod) {
		for(Consejo consj : listaConsejo.getConsejos()) {
			if (consj.getTitulo().equals(consejoMod.getTitulo())) {
				consj.setPosts(consejoMod.getPosts());
				consj.setAutor(consejoMod.getAutor());
			}
		}
	}

	@Override
	public Consejo getBy(String titulo) {
		Consejo consejoBuscado = new Consejo();
		for (Consejo consj : listaConsejo.getConsejos()) {
			if(consj.getTitulo().equals(titulo)) {
				consejoBuscado = consj;
				break;
			}
		}
		return consejoBuscado;
	}
	
}
