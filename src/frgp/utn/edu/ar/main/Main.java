package frgp.utn.edu.ar.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.HorarioTrabajo;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;

public class Main {

	public static void main(String[] args) {

		boolean estado = false;

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create"); // Cambia "update" por el valor que desees

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		sessionFactory.close();

		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

		// crear especialidad (objetos)
		Especialidad especialidad1 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad1.setNombre("Clinico");

		Especialidad especialidad2 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad2.setNombre("Pediatra");

		Especialidad especialidad3 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad3.setNombre("Cardiologo");

		Especialidad especialidad4 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad4.setNombre("Oftalmologia");

		Especialidad especialidad5 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad5.setNombre("Fisioterapia");

		Especialidad especialidad6 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad6.setNombre("Nutricionista");

		Especialidad especialidad7 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad7.setNombre("Dermatologia");

		List<Especialidad> especialidades = new ArrayList<Especialidad>();

		especialidades.add(especialidad1);
		especialidades.add(especialidad2);
		especialidades.add(especialidad3);
		especialidades.add(especialidad4);
		especialidades.add(especialidad5);
		especialidades.add(especialidad6);
		especialidades.add(especialidad7);

		// agregar a la base llamar bean
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");

		// usar metodo agregar si no esta

		Long count = (long) 1;
		for (Especialidad especialidad : especialidades) {
			estado = especialidadNegocio.exist(count);
			if (estado == false) {
				estado = especialidadNegocio.add(especialidad);
				System.out.println("cagado " + especialidad.getNombre());
			} else {
				System.out.println("ya existe " + especialidad.getNombre());
			}
			count += 1;
		}

		// traer las especilaidades
		System.out.println("\n ----- especialidades -----");
		List<Especialidad> listaEspecialidad = especialidadNegocio.readAll();
		listaEspecialidad.forEach(especialidad -> System.out.println(especialidad));

		Paciente paciente1 = (Paciente) appContext.getBean("beanPaciente");
		paciente1.setNombre("joel");
		paciente1.setApellido("fernandez");
		paciente1.setDni("12345678");
		paciente1.setTelefono("555-1234567");
		paciente1.setDireccion("Calle 123");
		paciente1.setLocalidad("Ciudad1");
		paciente1.setProvincia("Provincia1");
		paciente1.setFechaNacimiento("2000-01-01");
		paciente1.setCorreoElectronico("correo1@example.com");
		paciente1.setEstado(true);

		Paciente paciente2 = (Paciente) appContext.getBean("beanPaciente");
		paciente2.setNombre("walter");
		paciente2.setApellido("guerrero");
		paciente2.setDni("12345678");
		paciente2.setTelefono("555-1234567");
		paciente2.setDireccion("Calle 233");
		paciente2.setLocalidad("Ciudad1");
		paciente2.setProvincia("Provincia1");
		paciente2.setFechaNacimiento("2999-01-01");
		paciente2.setCorreoElectronico("correo1@example.com");
		paciente2.setEstado(true);

		Paciente paciente3 = (Paciente) appContext.getBean("beanPaciente");
		paciente3.setNombre("Esteban");
		paciente3.setApellido("corol");
		paciente3.setDni("12345678");
		paciente3.setTelefono("555-1234567");
		paciente3.setDireccion("Calle 233");
		paciente3.setLocalidad("Ciudad1");
		paciente3.setProvincia("Provincia1");
		paciente3.setFechaNacimiento("2999-01-01");
		paciente3.setCorreoElectronico("correo1@example.com");
		paciente3.setEstado(true);

		List<Paciente> pacientes = new ArrayList<Paciente>();

		for (int i = 1; i <= 21; i++) {
			Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
			paciente.setNombre("nombre" + i);
			paciente.setApellido("apellido" + i);
			paciente.setDni("1234567" + i);
			paciente.setTelefono("555-12345" + i);
			paciente.setDireccion("Calle " + i);
			paciente.setLocalidad("Localidad" + i);
			paciente.setProvincia("Buenos Aires");
			paciente.setFechaNacimiento("2000-01-" + (i < 10 ? "0" + i : i));
			paciente.setCorreoElectronico("correo" + i + "@example.com");
			paciente.setEstado(true);

			pacientes.add(paciente);
		}

		pacientes.add(paciente1);
		pacientes.add(paciente2);
		pacientes.add(paciente3);

		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");

		// pacientes carga a base de datos
		for (Paciente paciente : pacientes) {
			pacienteNegocio.add(paciente);
		}

		System.out.println("\n ----- pacientes -----");
		List<Paciente> listaPaciente = pacienteNegocio.readAll();
		for (Paciente paciente0 : listaPaciente) {
			System.out.println(paciente0);
		}

		// crear usuario (objetos)

		Usuario usuario1 = (Usuario) appContext.getBean("beanUsuario");
		usuario1.setNombreUsuario("walter");
		usuario1.setContrasenia("123");
		usuario1.setEstado(true);
		usuario1.setAdmin(true);

		Usuario usuario2 = (Usuario) appContext.getBean("beanUsuario");
		usuario2.setNombreUsuario("joel");
		usuario2.setContrasenia("123");
		usuario2.setEstado(true);
		usuario2.setAdmin(true);

		Usuario usuario3 = (Usuario) appContext.getBean("beanUsuario");
		usuario3.setNombreUsuario("daniel");
		usuario3.setContrasenia("123");
		usuario3.setEstado(true);
		usuario3.setAdmin(true);

		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Crear 15 usuarios

		for (int i = 1; i <= 15; i++) {
			Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
			usuario.setNombreUsuario("usuario" + i);
			usuario.setContrasenia("pass" + i);
			usuario.setEstado(true);
			usuario.setAdmin(false);

			usuarios.add(usuario);
		}

		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);

		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
		usuarios.forEach(usuario -> usuarioNegocio.add(usuario));

		System.out.println("\n ----- usuarios -----");
		usuarios = usuarioNegocio.readAll();
		usuarios.forEach(System.out::println);

		/* Horario medico */

		List <HorarioTrabajo> horariosMedico1 = new ArrayList<HorarioTrabajo>();
			
		for (int i = 0; i < 6; i++) {
				HorarioTrabajo horarioMedico1 = (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
				horarioMedico1.setDia("lunes");
				horarioMedico1.setHorario(String.valueOf(11+i));
				horariosMedico1.add(horarioMedico1);
		}

		HorarioTrabajo horarioMedico2 = (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
		horarioMedico2.setDia("jueves");
		horarioMedico2.setHorario("13:00-1600");

		HorarioTrabajo horarioMedico3 = (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
		horarioMedico3.setDia("lunes");
		horarioMedico3.setHorario("13:00-1600");

		/* Medico */

		Medico medico1 = (Medico) appContext.getBean("beanMedico");
		medico1.setApellido("gerez");
		medico1.setNombre("daniel");
		medico1.setSexo("M");
		medico1.setCorreoElectronico("fasdf@sfdsd");
		medico1.setDireccion("garibal 232");
		medico1.setFechaNacimiento("2000-01-02");
		medico1.setLocalidad("virreyes");
		medico1.setEspecialidad(especialidad1);
		medico1.setHorarioTrabajo(horariosMedico1);
		medico1.setUsuario(usuario1);
		medico1.setEstado(true);

		Medico medico2 = (Medico) appContext.getBean("beanMedico");
		medico2.setApellido("chavez");
		medico2.setNombre("jose");
		medico2.setSexo("M");
		medico2.setCorreoElectronico("fasdf@sfdsd");
		medico2.setDireccion("garibal 232");
		medico2.setEspecialidad(especialidad2);
		medico2.setFechaNacimiento("2000-01-02");
		medico1.setLocalidad("garin");
		/* medico2.addHorario(horarioMedico1); */ // error de key duplicada
		medico2.addHorario(horarioMedico2);
		medico2.addHorario(horarioMedico3);
		medico2.setUsuario(usuario2);
		medico2.setEstado(true);

		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		medicoNegocio.add(medico1);
		medicoNegocio.add(medico2);

		Random rand = new Random();
		List<Medico> medicos = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			Usuario usuario = usuarios.get(i);
			Especialidad especialidad = especialidades.get(rand.nextInt(especialidades.size()));

			Medico medico = (Medico) appContext.getBean("beanMedico");

			medico.setNombre("Nombre" + (i + 1));
			medico.setApellido("Apellido" + (i + 1));
			medico.setCorreoElectronico("correo" + (i + 1) + "@ejemplo.com");
			medico.setDireccion("Dirección" + (i + 1));
			medico.setLocalidad("localidad"+ (i + 1));
			medico.setTelefono("Telefono" + (i + 1));
			medico.setEstado(true);
			medico.setSexo((i % 2 == 0) ? "M" : "F");
			medico.setFechaNacimiento("1990-01-01");
			medico.setUsuario(usuario);
			medico.setEspecialidad(especialidad);

			medicos.add(medico);
			medicoNegocio.add(medico);
		}


		System.out.println("\n ----- medicos -----");
		List<Medico> listaMedico = medicoNegocio.readAll();
		for (Medico medico : listaMedico) {
			System.out.println(medico);
		}

		// turnos

		Turno turno1 = (Turno) appContext.getBean("beanTurno");
		turno1.setPaciente(paciente1); // Suponiendo que ya tienes paciente1 instanciado
		turno1.setFecha("2024-06-10");
		turno1.setHora("10:00");
		turno1.setObservacion("Consulta rutinaria");
		turno1.setEstado("Confirmado");
		turno1.setMedico(medico1);

		Turno turno2 = (Turno) appContext.getBean("beanTurno");
		turno2.setPaciente(paciente2); // Suponiendo que ya tienes paciente1 instanciado
		turno2.setFecha("2024-06-12");
		turno2.setHora("14:00");
		turno2.setObservacion("Consulta rutinaria");
		turno2.setEstado("Confirmado");
		turno2.setMedico(medico2);

//		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
//		boolean boolTurno1 = turnoNegocio.add(turno1);
//		boolean boolTurno2 = turnoNegocio.add(turno2);
//
//		System.out.println("\n ----- turnos -----");
//		List<Turno> listaTurno = turnoNegocio.readAll();
//		listaTurno.forEach(System.out::println);

		((ClassPathXmlApplicationContext) appContext).close();

	}

}
