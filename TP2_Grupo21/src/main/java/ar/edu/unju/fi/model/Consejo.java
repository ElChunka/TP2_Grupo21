package ar.edu.unju.fi.model;

public class Consejo {
	private String titulo;
	private String posts;
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
