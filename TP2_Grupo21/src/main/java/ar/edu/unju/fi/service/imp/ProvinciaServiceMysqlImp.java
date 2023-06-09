package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;


@Service("provinciaServiceMysql")
public class ProvinciaServiceMysqlImp implements IProvinciaService {
	
	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	
	@Override
	public List<Provincia> getProvincias() {
		
		return provinciaRepository.findAll();
	}

}
