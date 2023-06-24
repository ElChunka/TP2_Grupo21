package ar.edu.unju.fi.entity;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Component

@Entity
@Table(name="sucursales")
public class Sucursal {
    
	@Column(name="sucu_nombre")
	@NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
	@Column(name="sucu_direccion")
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    
    @Column(name="sucu_descripcion")
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    @Column(name="sucu_horaAbrir")
    @NotNull(message = "La hora de apertura es obligatoria")
    private LocalTime horaAbrir;
    
    @Column(name="sucu_horaCerrar")
    @NotNull(message = "La hora de cierre es obligatoria")
    private LocalTime horaCerrar;
    
    @Column(name="sucu_telefono")
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String telefono;
    

    @Column(name="sucu_email")
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    private String email;
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="sucu_id")
    private Long id;
    
    
    private boolean estado;
    
    @OneToOne( cascade = {CascadeType.ALL})
	@JoinColumn(name = "prov_id")
	private Provincia provincia;

    public Sucursal() {
        // Constructor por defecto
    }
    

    public Sucursal(String nombre, String direccion,  String descripcion, LocalTime horaAbrir, LocalTime horaCerrar,String telefono, String email, Long id, boolean estado, Provincia provincia) {

    	this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.horaAbrir = horaAbrir;
        this.horaCerrar = horaCerrar;
        this.telefono = telefono;
        this.email = email;
        this.id = id;
        this.estado = estado;
        this.provincia = provincia;


    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public LocalTime getHoraAbrir() {
        return horaAbrir;
    }
    
    public void setHoraAbrir(LocalTime horaAbrir) {
        this.horaAbrir = horaAbrir;
    }
    
    public LocalTime getHoraCerrar() {
        return horaCerrar;
    }
    
    public void setHoraCerrar(LocalTime horaCerrar) {
        this.horaCerrar = horaCerrar;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public boolean getEstado() {
    	return estado;
    }
    
    public void setEstado(boolean estado) {
    	this.estado = estado;
    }
	
	 


}

