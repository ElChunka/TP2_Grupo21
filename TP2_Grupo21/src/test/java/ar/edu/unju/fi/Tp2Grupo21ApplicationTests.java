package ar.edu.unju.fi;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;

@SpringBootTest
class Tp2Grupo21ApplicationTests {
	
	@Autowired
	@Qualifier("sucursalServiceMysql")
	private ISucursalService sucursalService;
	
	Sucursal sucursal;
	
	/*@Test
	void guardarSucursalTest() {
		
		sucursal = new Sucursal();
		sucursal.setNombre("Salud Pets 1");
		sucursal.setDireccion("Belgrano 405");
		sucursal.setDescripcion("Alimentos e Insumos Varios");
		sucursal.setHoraAbrir(LocalTime.of(9, 30));
		sucursal.setHoraCerrar(LocalTime.of(21, 0));
		sucursal.setTelefono("3884555205");
		sucursal.setEmail("saludpets1@gmail.com");
		sucursal.setEstado(true);
	}*/

}
