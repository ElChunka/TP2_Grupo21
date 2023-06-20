package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

@Service("sucursalServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService {
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public List<Sucursal> getSucursales() {
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

	@Override
	public void guardar(Sucursal sucursalGuardar) {
		sucursalRepository.save(sucursalGuardar);
	}

	@Override
	public void modificar(Sucursal sucursalMod) {
		sucursalRepository.save(sucursalMod);

	}

	@Override
	public Sucursal getBy(Long id) {
		return sucursalRepository.findById(id).get();
	}

	@Override
	public void eliminar(Sucursal sucursalEliminar) {
		sucursalEliminar.setEstado(false);
		sucursalRepository.save(sucursalEliminar);

	}

}
