package frgp.utn.edu.ar.entidad;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		
		@OneToOne(cascade= {CascadeType.ALL})
		@JoinColumn(name="id_usuario")
		private Usuario usuario;
			
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
		
		//constructor vacio
		public Medico() {
			super();
		}
		
		public Medico(int legajo, String nombre, String apellido, String sexo, String fechaNacimiento, String direccion,
				String localidad, String correoElectronico, String telefono) {
			super();
			this.legajo = legajo;
			this.nombre = nombre;
			this.apellido = apellido;
			this.sexo = sexo;
			this.fechaNacimiento = fechaNacimiento;
			this.direccion = direccion;
			this.localidad = localidad;
			this.correoElectronico = correoElectronico;
			this.telefono = telefono;
		}



		public Medico( String nombre, String apellido, String sexo, String fechaNacimiento, String direccion,
				String localidad, String correoElectronico, String telefono) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.sexo = sexo;
			this.fechaNacimiento = fechaNacimiento;
			this.direccion = direccion;
			this.localidad = localidad;
			this.correoElectronico = correoElectronico;
			this.telefono = telefono;
		}
		
		public Medico(Usuario usuario, Especialidad especialidad, int legajo, String nombre, String apellido, String sexo,
				String fechaNacimiento, String direccion, String localidad, String correoElectronico, String telefono) {
			super();
			this.usuario = usuario;
			this.especialidad = especialidad;
			this.legajo = legajo;
			this.nombre = nombre;
			this.apellido = apellido;
			this.sexo = sexo;
			this.fechaNacimiento = fechaNacimiento;
			this.direccion = direccion;
			this.localidad = localidad;
			this.correoElectronico = correoElectronico;
			this.telefono = telefono;
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

	}


