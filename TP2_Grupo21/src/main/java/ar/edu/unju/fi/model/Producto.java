package ar.edu.unju.fi.model;

public class Producto {
	
	private String nombre, categoria, img="R.png";
	private int descuento, codigo;
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
