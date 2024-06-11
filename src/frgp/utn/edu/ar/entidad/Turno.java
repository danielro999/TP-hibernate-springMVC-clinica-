package frgp.utn.edu.ar.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TURNOS")
public class Turno implements Serializable {
	
	//implementar serializable
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    
    private String fecha;
    
    private String hora;
    private String observacion;
    private String estado;
    
    
    public Turno() {
		
   	}
    
  	public Turno( int id, Medico medico, Paciente paciente, String fecha, String hora, String observacion, String estado) {
   		super();
   		this.id = id;
   		this.medico = medico;
   		this.paciente = paciente;
   		this.fecha = fecha;
   		this.hora = hora;
   		this.observacion = observacion;
   		this.estado = estado;
   	}

      
   	public Turno(Medico medico, Paciente paciente, String fecha, String hora, String observacion, String estado) {
   		super();
   		this.medico = medico;
   		this.paciente = paciente;
   		this.fecha = fecha;
   		this.hora = hora;
   		this.observacion = observacion;
   		this.estado = estado;
   	}

    // Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		String medicoLegajo = (medico != null) ? String.valueOf(medico.getLegajo()) : "null";
	    String pacienteId = (paciente != null) ? paciente.getId().toString() : "null";
	    return "Turno [id=" + id + 
	            ", medico=" + medicoLegajo +
	            ", paciente=" + pacienteId +
	            ", fecha=" + fecha +
	            ", hora='" + hora + '\'' +
	            ", observacion='" + observacion + '\'' +
	            ", estado='" + estado + '\'';
	}
}