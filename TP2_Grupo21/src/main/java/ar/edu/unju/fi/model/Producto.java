package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component
public class Producto {
	
	@NotBlank(message="No puede estar vacio")
	@Pattern(regexp="[a-zA-Z]+", message="El nombre solo admite una palabra")
	@Size(min=5,max=30,message="El nombre del Producto debe tener entre 5 y 30 caracteres")
	private String nombre;
	@Size(min=4,max=30,message="La categoria del nuevo producto debe tener entre 4 y 3o caracteres")
	@NotBlank(message="No puede estar vacio")
	private String categoria;
	@NotEmpty(message="No puede estar vacio")
	private String img="R.png";
	@Min(value=1, message="Debe Definir un codigo para el producto")
	@NotNull(message="Ingrese el codigo")
	private int codigo;
	@PositiveOrZero(message="Solo puede ingresar numeros")
	private int descuento;
	@PositiveOrZero(message="Solo puede ingresar numeros")
	private double precio; 
	
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
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
	
	public Producto(String nombre, String categoria, int descuento, int codigo, double precio, String img) {
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
}
