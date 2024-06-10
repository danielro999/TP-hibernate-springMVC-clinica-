package frgp.utn.edu.ar.entidad;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESPECIALIDADES")
public class Especialidad implements Serializable {
	
	//implementar serializable
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_especialidad;
    
    private String nombre;
    
    //@OneToMany(mappedBy = "especialidad")
   // private List<Medico> medicos;

	public Especialidad() {
		super();
	}
	
	public Especialidad(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Especialidad(Long id, String nombre) {
		super();
		this.id_especialidad = id;
		this.nombre = nombre;
	}

	// Getters y Setters
	public Long getId() {
		return id_especialidad;
	}

	public void setId(Long id) {
		this.id_especialidad = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*
	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	*/

	@Override
	public String toString() {
		return "Especialidad [id=" + id_especialidad + ", nombre=" + nombre + "]";
	}
	
}
