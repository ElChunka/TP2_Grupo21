package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;

@Service("consejoServiceMysql")
public class ConsejoServiceMysqlImp implements IConsejoService {

	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> getConsejos() {
		return consejoRepository.findByEstado(true);
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}

	@Override
	public void guardar(Consejo consejoGuardar) {
		consejoGuardar.setEstado(true);
		consejoRepository.save(consejoGuardar);
	}

	@Override
	public void modificar(Consejo consejoMod) {
		consejoRepository.save(consejoMod);
	}

	@Override
	public Consejo getBy(Long id) {
		return consejoRepository.findById(id).get();
	}

	@Override
	public void eliminar(Consejo consejoEliminar) {
		consejoEliminar.setEstado(false);
		consejoRepository.save(consejoEliminar);
	}

}
