package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="consejos")
public class Consejo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="con_id")
	private Long id;
	
	@Column(name="con_titulo")
	@NotBlank(message="Debe ingresar un titulo")
	private String titulo;
	
	@Column(name="con_posts")
	@NotBlank(message="Debe ingresar un consejo de salud")
	@Size(min=30, max=5000,message="Debe escribir un texto con entre 30 y 5000 caracteres")
	private String posts;
	
	@Column(name="con_autor")
	@NotBlank(message="Debe ingresar un autor")
	private String autor;
	
	@Column(name="con_estado")
	private boolean estado;
	
	public Consejo () {
	}
	
	public Consejo (Long id, String titulo, String posts, String autor, boolean estado) {
		this.id=id;
		this.titulo=titulo;
		this.posts=posts;
		this.autor=autor;
		this.estado=estado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
