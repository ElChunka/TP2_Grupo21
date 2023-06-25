package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component

@Entity
@Table(name="productos")
public class Producto {
	
	@Column(name = "nombre_producto")
	@NotBlank(message="No puede estar vacio")
	@Pattern(regexp="[a-zA-Z]+", message="El nombre solo admite una palabra")
	@Size(min=5,max=30,message="El nombre del Producto debe tener entre 5 y 30 caracteres")
	private String nombre;

	
			@Column(name = "producto_categoria")
			@Size(min=4,max=30,message="La categoria del nuevo producto debe tener entre 4 y 3o caracteres")
			@NotBlank(message="No puede estar vacio")
			private String categoria;
	
	@NotEmpty(message="No puede estar vacio")
	private String img="R.png";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_codigo")
	private Long codigo;
	
	@Column(name = "producto_descuento")
	@PositiveOrZero(message="Solo puede ingresar numeros")
	private int descuento;
	
	@Column(name = "producto_precio")
	@PositiveOrZero(message="Solo puede ingresar numeros")
	private double precio; 
	
	@Column(name = "producto_estado")
	private boolean estado;
	
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {

		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Producto() {
	}
	

	public Producto(String nombre,String categoria, int descuento, Long codigo, double precio, String img) {

		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descuento = descuento;
		this.codigo = codigo;
		this.precio = precio;
		this.img = img;
	}
	
	public double calcularDescuento()
	{
		
		double resta = (double) descuento/100*precio;
		double precioFinal = precio - resta;

		 
		return Math.round(precioFinal);
	}
	
	/*@OneToOne
	@JoinColumn(name= "id codigo")*/
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	 

}
