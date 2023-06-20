package ar.edu.unju.fi.listas;
import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;

import java.util.ArrayList;


@Component
public class ListaConsejo {
	private List<Consejo> consejos;
	
	public ListaConsejo() {
		consejos = new ArrayList<Consejo>();
	}
	
	public List<Consejo> getConsejos(){
		return consejos;
	}
	
	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}
}
