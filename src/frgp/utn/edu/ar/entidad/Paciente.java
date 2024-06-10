package frgp.utn.edu.ar.entidad;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PACIENTES")
public class Paciente implements Serializable {
	
	//implementar serializable
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String localidad;
    private String provincia;
    private String fechaNacimiento;
    private String correoElectronico;
    private boolean estado;
    
public Paciente() {
		
	}
    
	public Paciente(String nombre, String apellido, String dni, String telefono, String direccion, String localidad,
			String provincia, String fechaNacimiento, String correoElectronico, boolean estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaNacimiento = fechaNacimiento;
		this.correoElectronico = correoElectronico;
		this.estado = estado;
	}


    // Getters y Setters
    
   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	 @Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", telefono="
				+ telefono + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", fechaNacimiento=" + fechaNacimiento + ", correoElectronico=" + correoElectronico + ", estado="
				+ estado + "]";
	}


}