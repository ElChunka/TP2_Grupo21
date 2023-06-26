package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.service.IServicioService;

@Service("servicioServiceImp")
public class ServicioServiceImp implements IServicioService{
	
	@Autowired
	ListaServicio servicios;
	
    @Autowired
    private Servicio servicio;
	@Override
	public List<Servicio> getServicios(){
		return servicios.getServicios();
	}
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	@Override
	public void guardar(Servicio servicio) { //el metodo recibe un objeto de tipo servicio
		if(getServicios().size()==1)  //verifica la cant de elementos de la lista
			getServicios().set(0, servicio); //agrega el primer elemento en caso de tener una lista vacia
		else {
			getServicios().add(servicio); //agrega a la lista si hay mas elementos
		}
	}
	@Override
	public void listar() {
		for(Servicio s:getServicios()) System.out.println(s.toString()); //lista los elementos de la lista en la consola
	}
	@Override
	public void modificar(Servicio servicio){
		for (Servicio s : getServicios()) { //recorre la lista
            if (s.getId() == servicio.getId()) { //busca una coincidencia con el id
            	//setea todos los campos en caso de encocntrar coincidencia
                s.getEmpleado().setNombre(servicio.getEmpleado().getNombre());
                s.setHoraInicio(servicio.getHoraInicio());
                s.setHoraFin(servicio.getHoraFin());
                s.setDia(servicio.getDia());
                break;
            }
        }
	}
	@Override
	public void eliminar(Servicio servicio) {
		getServicios().remove(servicio); //elimina el objeto pasado por parametro
	}
	@Override
	public boolean buscar(Long id){
		boolean encontrado=false; //variable de retorno
		for (Servicio s : getServicios()) { //recorre la lista
            if (s.getId() == id) { //busca coincidencia
            	encontrado= true; //el valor cambia si se encuentra coincidencia
            	break;
            }
        }
		return encontrado;
	}
	@Override
	public Servicio recuperar(Long id) { //devuelve el objeto segun su id
		Servicio serv=new Servicio(); 
		for (Servicio s : getServicios()) { 
            if (s.getId() == id) { 
            	serv=s;
            }
        }
		return serv;
	}
	@Override
	public List<Servicio> getServiciosByDay(String dia) {
		// TODO Auto-generated method stub
		return null;
	}
}
