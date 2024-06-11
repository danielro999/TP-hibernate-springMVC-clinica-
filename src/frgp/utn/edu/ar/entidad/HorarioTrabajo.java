package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HORARIOTRABAJO")
public class HorarioTrabajo implements Serializable{

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id_HT;
		
	    private String dia;
	    
	    private String horario;
	    
	    public HorarioTrabajo() {
	
	    }
	    public HorarioTrabajo(String dia, String horario) {
	        this.dia = dia;
	        this.horario = horario;
	    }

	    public String getDia() {
	        return dia;
	    }

	    public void setDia(String dia) {
	        this.dia = dia;
	    }

	    public String getHorario() {
	        return horario;
	    }

	    public void setHorario(String horario) {
	        this.horario = horario;
	    }
	 /*   
	    public Medico getMedico() {
			return medico;
		}

		public void setMedico(Medico medico) {
			this.medico = medico;
		}
*/

		@Override
		public String toString() {
			return "Horario de trabajo [dia=" + dia + ", horario=" + horario + "]";
		}

	 
}
