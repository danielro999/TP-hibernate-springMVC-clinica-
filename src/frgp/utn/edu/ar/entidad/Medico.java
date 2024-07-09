package frgp.utn.edu.ar.entidad;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;


	@Entity
	@Table(name="MEDICOS")
	public class Medico implements Serializable {
		
		//implementar serializable
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int legajo;
		
		@ManyToOne(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="id_especialidad")
		private Especialidad especialidad;
		
		@OneToOne(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="id_usuario")
		private Usuario usuario;
			
		@OneToMany(cascade= {CascadeType.ALL})
		private List<HorarioTrabajo> listaHorarioTrabajo=new ArrayList<HorarioTrabajo>();
		
		private String nombre;
		private String apellido;
		private String sexo;
		
		@Column(name="fecha_nacimiento")
		private String fechaNacimiento;
		private String direccion;
		private String localidad;
		
		@Column(name="correo_electronico")
		private String correoElectronico;
		private String telefono;
		private boolean estado;

		//constructor vacio
		public Medico() {
			super();
		
		}
	
		public Medico(int legajo, Especialidad especialidad, Usuario usuario, List<HorarioTrabajo> listaHorarioTrabajo,
				String nombre, String apellido, String sexo, String fechaNacimiento, String direccion, String localidad,
				String correoElectronico, String telefono, boolean estado) {
			super();
			this.legajo = legajo;
			this.especialidad = especialidad;
			this.usuario = usuario;
			this.listaHorarioTrabajo = listaHorarioTrabajo;
			this.nombre = nombre;
			this.apellido = apellido;
			this.sexo = sexo;
			this.fechaNacimiento = fechaNacimiento;
			this.direccion = direccion;
			this.localidad = localidad;
			this.correoElectronico = correoElectronico;
			this.telefono = telefono;
			this.estado = estado;
		}

		public List<HorarioTrabajo> getListaHorarioTrabajo() {
			return listaHorarioTrabajo;
		}

		public void setListaHorarioTrabajo(List<HorarioTrabajo> listaHorarioTrabajo) {
			this.listaHorarioTrabajo = listaHorarioTrabajo;
		}

		
		public void addHorario(HorarioTrabajo HorarioTrabajo) {
			this.listaHorarioTrabajo.add(HorarioTrabajo);
		}

		public boolean isEstado() {
			return estado;
		}


		public void setEstado(boolean estado) {
			this.estado = estado;
		}


		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Especialidad getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(Especialidad especialidad) {
			this.especialidad = especialidad;
		}

		public int getLegajo() {
			return legajo;
		}

		public void setLegajo(int legajo) {
			this.legajo = legajo;
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

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
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

		public String getCorreoElectronico() {
			return correoElectronico;
		}

		public void setCorreoElectronico(String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
			

		//met ToString()
		
		@Override
		public String toString() {
			String mensaje = "Medico [legajo=" + legajo + ", nombre="
					+ nombre + ", apellido= " + apellido + ", estado= "+ estado +"]";
			if (usuario != null) {
				mensaje += ", usiario= " + usuario.getNombreUsuario();
			}
			if (especialidad != null) {
				mensaje += ", especialidad= " + especialidad.getNombre();
			}
			for (HorarioTrabajo horarioTrabajo2 : this.listaHorarioTrabajo) {
				mensaje += "\n      ," +horarioTrabajo2;
			}
			
			return mensaje;
		}
		
		
		/*
		 * @Override
		public String toString() {
			String mensaje = "Medico [legajo=" + legajo + ", nombre="
					+ nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento
					+ ", direccion=" + direccion + ", localidad=" + localidad + ", correoElectronico=" + correoElectronico
					+ ", telefono=" + telefono + "]";
			if (usuario != null) {
				mensaje += ", usiario= " + usuario.getNombreUsuario();
			}
			if (especialidad != null) {
				mensaje += ", especialidad= " + especialidad.getNombre();
			}
			return mensaje;
		}
		*/

	}


