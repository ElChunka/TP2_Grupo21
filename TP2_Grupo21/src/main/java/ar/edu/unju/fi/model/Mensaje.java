package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Component
public class Mensaje {
	@NotBlank(message="Debe escribir un nombre")
	private String remitente;
	@NotEmpty(message="Eliga una ciudad")
	private String ciudad;
	@Email(message="Debe anotar una direccion de correo valida")
	@NotBlank(message="Debe escribir un email")
	private String email;
	@Size(min=4,max=100,message="El mensaje de tener entre 4 y 100 caracteres")
	private String mensaje;
	@Min(value=1, message="Ingrese un codigo")
	@NotNull(message="Ingrese un codigo")
	private Integer cod;
	
	public Mensaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensaje(String remitente, String ciudad, String email, String mensaje, Integer cod) {
		super();
		this.remitente = remitente;
		this.ciudad = ciudad;
		this.email = email;
		this.mensaje = mensaje;
		this.cod = cod;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}