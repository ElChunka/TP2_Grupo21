package ar.edu.unju.fi.listas;
import java.util.List;
import java.util.ArrayList;
import ar.edu.unju.fi.model.Consejo;

public class ListaConsejo {
	private List<Consejo> consejos;
	
	public ListaConsejo() {
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo("Hierba para Gatos", "Es muy bueno para el higado","Alfaro Facundo"));
		consejos.add(new Consejo("Collar para Gatos", "Previene el virus de la rabia detectada en animales como perros y gatos y es transmitida por pulgas","Alfaro Facundo"));
		consejos.add(new Consejo("Pastillas para Gatos", "Es muy bueno para el higado","Alfaro Facundo"));
	}
	
	public List<Consejo> getConsejos(){
		return consejos;
	}
	
	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}
}
