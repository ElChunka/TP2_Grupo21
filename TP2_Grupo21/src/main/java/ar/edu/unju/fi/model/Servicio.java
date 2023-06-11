package ar.edu.unju.fi.model;
import java.time.LocalTime;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;

@Component
public class Servicio {
	@NotBlank(message="No puede estar vacio")
	@Size(min=5,max=20,message="El nombre debe tener entre 5 y 20 caracteres")
    private String nombre;
	
	
	@NotNull(message = "El id no puede ser nula")
	@Digits(integer = 3, message = "El valor del id debe ser un número entero de un dígito", fraction = 0)
	@Min(value = 1, message = "El valor del id debe ser mayor o igual a 1")
    private int id;
	
	
	
	@NotNull(message = "La hora de inicio no puede ser nula")
    private LocalTime horaInicio;
	
	
	@NotNull(message = "La hora de fin no puede ser nula")
    private LocalTime horaFin;
	
	@NotNull(message = "La hora de fin no puede ser nula")
	@NotBlank(message="No puede estar vacio")
    private String dia;

    public Servicio() {
    }

    public Servicio(String nombre, int id,  LocalTime horaInicio, LocalTime horaFin, String dia) {
        this.nombre = nombre;
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
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
}
