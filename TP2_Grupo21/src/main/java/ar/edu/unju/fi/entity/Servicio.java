package ar.edu.unju.fi.entity;
import java.time.LocalTime;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Digits;
//import jakarta.validation.constraints.Min;

@Component
@Entity
@Table(name="servicios")
public class Servicio {
	@Column(name="serv_nombre")
	@NotBlank(message="No puede estar vacio")
	@Size(min=5,max=20,message="El nombre debe tener entre 5 y 20 caracteres")
    private String nombre;
	
	
	//@NotNull(message = "El id no puede ser nula")
	//@Digits(integer = 3, message = "El valor del id debe ser un número entero de un dígito", fraction = 0)
	//@Min(value = 1, message = "El valor del id debe ser mayor o igual a 1")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serv_id")
    private Long id;
	
	
	@Column(name="serv_hora_inicio")
	@NotNull(message = "La hora de inicio no puede ser nula")
    private LocalTime horaInicio;
	
	@Column(name="serv_hora_fin")
	@NotNull(message = "La hora de fin no puede ser nula")
    private LocalTime horaFin;
	
	@Column(name="serv_dia")
	@NotNull(message = "La hora de fin no puede ser nula")
	@NotBlank(message="No puede estar vacio")
    private String dia;
	
	@Column(name="serv_estado")
	private boolean estado;

    public Servicio() {
    }

    public Servicio(String nombre,  LocalTime horaInicio, LocalTime horaFin, String dia) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
    }

    public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

	@Override
	public String toString() {
		return "Servicio [nombre=" + nombre + ", id=" + id + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", dia=" + dia + "]";
	}
    
}
