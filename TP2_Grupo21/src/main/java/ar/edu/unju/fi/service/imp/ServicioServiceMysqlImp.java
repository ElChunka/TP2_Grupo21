package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;
@Service("servicioServiceMysqlImp")
public class ServicioServiceMysqlImp implements IServicioService {
	
	 @Autowired
	 private IServicioRepository servicioRepository;
	 
	 @Autowired
	 private Servicio servicio;

	@Override
	public List<Servicio> getServicios() {
		return servicioRepository.findByEstado(true);
	}

	@Override
	public Servicio getServicio() {
		return servicio;
	}

	@Override
	public void guardar(Servicio servicio) {
		servicio.setEstado(true);
		servicio.getEmpleado().setEstado(false);
		servicioRepository.save(servicio);
	}

	@Override
	public void listar() {
		for(Servicio s:getServicios()) System.out.println(s.toString()); //lista los elementos de la lista en la consola
	}

	@Override
	public void modificar(Servicio servicio) {
		servicioRepository.save(servicio);
	}

	@Override
	public void eliminar(Servicio servicio) {
		servicio.setEstado(false);
		servicioRepository.save(servicio);
	}

	@Override
	public boolean buscar(Long id) {
		return servicioRepository.existsById(id);
	}

	@Override
	public Servicio recuperar(Long id) {
		return servicioRepository.findById(id).get();
	}

	@Override
	public List<Servicio> getServiciosByDay(String dia) {
		List<Servicio> servicios = new ArrayList<>();
		for(Servicio s:getServicios()) {
			if(s.getDia().equals(dia))
				servicios.add(s);
		};
		if(servicios.size()==0) {
			return null;
		}
		return servicios;
	}

}
