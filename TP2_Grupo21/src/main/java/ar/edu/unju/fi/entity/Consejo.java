package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
public class Consejo {
	@NotBlank(message="Debe ingresar un titulo")
	private String titulo;
	@NotBlank(message="Debe ingresar un consejo de salud")
	@Size(min=30, max=5000,message="Debe escribir un texto con entre 30 y 5000 caracteres")
	private String posts;
	@NotBlank(message="Debe ingresar un autor")
	private String autor;
	
	public Consejo () {
	}
	
	public Consejo (String titulo, String posts, String autor) {
		this.titulo=titulo;
		this.posts=posts;
		this.autor=autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPosts() {
		return posts;
	}
	public void setPosts(String posts) {
		this.posts = posts;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
