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
		
	    private boolean lunes;
	    
	    private boolean martes;
	    
	    private boolean miercoles;
	    
	    private boolean jueves;
	    
	    private boolean viernes;
	    
	    private boolean sabado;
	    
	    private boolean domingo;
	    
	    public HorarioTrabajo() {
	
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public boolean isLunes() {
			return lunes;
		}

		public void setLunes(boolean lunes) {
			this.lunes = lunes;
		}

		public boolean isMartes() {
			return martes;
		}

		public void setMartes(boolean martes) {
			this.martes = martes;
		}

		public boolean isMiercoles() {
			return miercoles;
		}

		public void setMiercoles(boolean miercoles) {
			this.miercoles = miercoles;
		}

		public boolean isJueves() {
			return jueves;
		}

		public void setJueves(boolean jueves) {
			this.jueves = jueves;
		}

		public boolean isViernes() {
			return viernes;
		}

		public void setViernes(boolean viernes) {
			this.viernes = viernes;
		}

		public boolean isSabado() {
			return sabado;
		}

		public void setSabado(boolean sabado) {
			this.sabado = sabado;
		}

		public boolean isDomingo() {
			return domingo;
		}

		public void setDomingo(boolean domingo) {
			this.domingo = domingo;
		}

		@Override
		public String toString() {
			return "HorarioTrabajo [id=" + id + ", lunes=" + lunes + ", martes=" + martes + ", miercoles=" + miercoles
					+ ", jueves=" + jueves + ", viernes=" + viernes + ", sabado=" + sabado + ", domingo=" + domingo
					+ "]";
		}

	

	 
}
