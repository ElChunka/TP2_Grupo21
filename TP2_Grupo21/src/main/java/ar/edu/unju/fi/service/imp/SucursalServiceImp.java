package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements ISucursalService{
	
	@Autowired
	private ListaSucursal listaSucursal;
	@Autowired
	private Sucursal sucursal;

	@Override
	public List<Sucursal> getSucursales() {
		
		return listaSucursal.getSucursales();
	}
	
	public Sucursal getSucursal() {
		return sucursal;
	}

	@Override
	public void guardar(Sucursal sucursalGuardar) {
		listaSucursal.getSucursales().add(sucursalGuardar);		
	}

	@Override
	public void modificar(Sucursal sucursalMod) {
		for (Sucursal serv : listaSucursal.getSucursales()) {
			if (serv.getId() == sucursal.getId()) {
				serv.setNombre(sucursal.getNombre());
				serv.setDireccion(sucursal.getDireccion());
				serv.setDescripcion(sucursal.getDescripcion());
				serv.setHoraAbrir(sucursal.getHoraAbrir());
				serv.setHoraCerrar(sucursal.getHoraCerrar());
				serv.setTelefono(sucursal.getTelefono());
				serv.setEmail(sucursal.getEmail());
				break;
			}
		}
		
	}

	@Override
	public void eliminar(Sucursal sucursalEliminar) {
		listaSucursal.getSucursales().remove(sucursalEliminar);
		
	}

	@Override
	public Sucursal getBy(int id) {
		Sucursal sucursalBuscada = new Sucursal(); 
		for (Sucursal sucu : listaSucursal.getSucursales()) {
			if (sucu.getId() == id) {
				sucursalBuscada = sucu;
				break;
			}
		}
		return sucursalBuscada;
	}
	

}