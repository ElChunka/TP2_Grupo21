package ar.edu.unju.fi.model;

public class Producto {
	
	private String nombre, categoria;
	private int descuento, codigo;
	private double precio;
	
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
	
	public Producto(String nombre, String categoria, int descuento, int codigo, double precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descuento = descuento;
		this.codigo = codigo;
		this.precio = precio;
	}
	
	public double calcularDescuento()
	{
		return (precio - (precio * ((double)descuento/100)));
	}
}