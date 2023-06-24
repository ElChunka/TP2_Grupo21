package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;

@Service("empleadoServiceMysqlImp")
public class EmpleadoServiceMysqlImp implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	private Empleado empleado;

	@Override
	public List<Empleado> getEmpleados() {
		return empleadoRepository.findByEstado("activo");
	}

	@Override
	public Empleado getEmpleado() {
		return empleado;
	}

	@Override
	public void guardar(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public void eliminar(Empleado empleado) {
		empleado.setEstado("deBaja");
		empleadoRepository.save(empleado);
	}

	@Override
	public void recuperar(Long id) {
		empleadoRepository.findById(id);
	}

}
