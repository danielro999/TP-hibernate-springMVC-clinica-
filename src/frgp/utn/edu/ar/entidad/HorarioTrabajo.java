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
		private int id;
		
	    private String lunes;
	    
	    private String martes;
	    
	    private String miercoles;
	    
	    private String jueves;
	    
	    private String viernes;
	    
	    private String sabado;
	    
	    private String domingo;
	    
	    public HorarioTrabajo() {
	
	    }

		public String getLunes() {
			return lunes;
		}

		public void setLunes(String lunes) {
			this.lunes = lunes;
		}

		public String getMartes() {
			return martes;
		}

		public void setMartes(String martes) {
			this.martes = martes;
		}

		public String getMiercoles() {
			return miercoles;
		}

		public void setMiercoles(String miercoles) {
			this.miercoles = miercoles;
		}

		public String getJueves() {
			return jueves;
		}

		public void setJueves(String jueves) {
			this.jueves = jueves;
		}

		public String getViernes() {
			return viernes;
		}

		public void setViernes(String viernes) {
			this.viernes = viernes;
		}

		public String getSabado() {
			return sabado;
		}

		public void setSabado(String sabado) {
			this.sabado = sabado;
		}

		public String getDomingo() {
			return domingo;
		}

		public void setDomingo(String domingo) {
			this.domingo = domingo;
		}

		@Override
		public String toString() {
			return "HorarioTrabajo [id=" + id + ", lunes=" + lunes + ", martes=" + martes + ", miercoles=" + miercoles
					+ ", jueves=" + jueves + ", viernes=" + viernes + ", sabado=" + sabado + ", domingo=" + domingo
					+ "]";
		}

	 
}
