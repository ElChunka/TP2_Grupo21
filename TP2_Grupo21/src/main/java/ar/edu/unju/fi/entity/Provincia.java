package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Component

@Entity
@Table(name = "provincias")
public class Provincia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "prov_id")
	private Long id;
	
	@Column(name = "prov_nombre")
	private String nombre;
	
	/*@OneToOne( cascade = {CascadeType.ALL})
	@JoinColumn(name = "sucu_id")
	private Sucursal sucursal;*/

	public Provincia() {
		
	}

	public Provincia(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}*/

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ",]";
	}
		
	
}
