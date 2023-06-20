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
		consejos.add(new Consejo("Hierba para Gatos", "Cuando ponemos a un gato en contacto con la hierba para gatos, el animal se frota, la lame y lo mastica con inusual interés, incluso llegan a emitir sonidos similares a los que produce la hembra durante el celo. No está claro el por qué algunos gatos reaccionan de esta manera y otros no (a un 30% de los gatos no les afecta la hierba gatera). La responsable del efecto narcótico de la hierba es una molécula llamada nepetalactona, que penetra en las fosas nasales de los gatos y estimula sus neuronas sensitivas. El efecto estimulante de la hierba gatera dura unos diez minutos como mucho tras la exposición y luego puede estar más de 30 minutos inmune a sus encantos. Algunos gatos se quedan muy relajados tras su exposición y mirando hacia el vacío y otros sin embargo se excitan mucho y se vuelven hiperactivos","Alfaro Facundo"));
		consejos.add(new Consejo("El cuidado de un perro mayor", "El perro anciano duerme más horas que un perro adulto, pero que esto no te confunda: necesita pasear y socializar como cualquier otro perro. Para ello es importante que adaptemos el ejercicio físico a tu situación concreta ya que los perros que son muy mayores tienen una actividad física reducida, pero que igualmente debe mantenerse.","Andres Sanchez"));
		consejos.add(new Consejo("Consejos para el cuidado de peces", "Lo mejor para los peces no es el agua directa del grifo, ya que puede tener un exceso de cloro y otras sustancias que les resultan perjudiciales. ¿Significa eso que hay que usar agua mineral? ¡Nooo! Basta con la del grifo, pero hay que acondicionarla antes de echarla en la pecera. En tiendas de productos para mascotas encontrarás los preparados especiales para preparar el agua de tus peces.","Franco Rodriguez"));
	}
	
	public List<Consejo> getConsejos(){
		return consejos;
	}
	
	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}
}
