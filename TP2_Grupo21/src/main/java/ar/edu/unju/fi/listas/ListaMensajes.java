package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Mensaje;
@Component
public class ListaMensajes {
	
	private List<Mensaje> mensajes;
	
	public ListaMensajes(){
		mensajes=new ArrayList<Mensaje>();
		mensajes.add(new Mensaje("Anonimo", "Ciudad 1", "example@domain.com", "A random message",0));
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
}
