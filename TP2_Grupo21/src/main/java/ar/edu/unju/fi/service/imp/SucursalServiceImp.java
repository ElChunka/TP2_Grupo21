package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Service("sucursalServiceImp")
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
	        if (serv.getId() == sucursalMod.getId()) {
	            serv.setNombre(sucursalMod.getNombre());
	            serv.setDireccion(sucursalMod.getDireccion());
	            serv.setDescripcion(sucursalMod.getDescripcion());
	            serv.setHoraAbrir(sucursalMod.getHoraAbrir());
	            serv.setHoraCerrar(sucursalMod.getHoraCerrar());
	            serv.setTelefono(sucursalMod.getTelefono());
	            serv.setEmail(sucursalMod.getEmail());
	            break;
	        }
	    }
	}

	@Override
	public void eliminar(Sucursal sucursalEliminar) {
		listaSucursal.getSucursales().remove(sucursalEliminar);
		
	}

	@Override
	public Sucursal getBy(Long id) {
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
