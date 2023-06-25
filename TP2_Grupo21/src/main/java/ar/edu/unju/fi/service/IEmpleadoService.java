package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleado;

public interface IEmpleadoService {
	List<Empleado> getEmpleados();
	Empleado getEmpleado();
	void guardar(Empleado empleado);
	void eliminar(Empleado empleado);
	void recuperar(Long id);
}
