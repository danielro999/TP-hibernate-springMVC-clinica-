package frgp.utn.edu.ar.main;

import java.util.List;
import java.util.Scanner;

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

		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

		// crear especialidad (objetos)
		Especialidad especialidad1 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad1.setNombre("clinico");
	
		Especialidad especialidad2 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad2.setNombre("pediatrico");

		Especialidad especialidad3 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad3.setNombre("cardiologo");

		Especialidad especialidad4 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad4.setNombre("diabetologo");


		// agregar a la base llamar bean
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");

		// usar metodo agregar si no esta

		estado = especialidadNegocio.exist(1);
		if (estado == false) {
			estado = especialidadNegocio.add(especialidad1);
		} else {
			System.out.println("ya existe clinico");
		}

		estado = especialidadNegocio.exist(2);
		if (estado == false) {
			estado = especialidadNegocio.add(especialidad2);
		} else {
			System.out.println("ya existe pediatrico");
		}

		estado = especialidadNegocio.exist(3);
		if (estado == false) {
			estado = especialidadNegocio.add(especialidad3);
		} else {
			System.out.println("ya existe cardiologo");
		}

		estado = especialidadNegocio.exist(4);
		if (estado == false) {
			estado = especialidadNegocio.add(especialidad4);
		} else {
			System.out.println("ya existe diabetologo");
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
	

		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		boolean agregado = pacienteNegocio.add(paciente1);
		boolean agregado2 = pacienteNegocio.add(paciente2);

		System.out.println("\n ----- pacientes -----");
		List<Paciente> listaPaciente = pacienteNegocio.readAll();
		for (Paciente paciente0 : listaPaciente) {
			System.out.println(paciente0);
		}
		
		// crear usuario (objetos)
		Usuario usuario1 = (Usuario) appContext.getBean("beanUsuario");
		usuario1.setNombreUsuario("BELA");
		usuario1.setContrasenia("elmasgrande");
		usuario1.setEstado(true);

		Usuario usuario2 = (Usuario) appContext.getBean("beanUsuario");
		usuario2.setNombreUsuario("Tapia");
		usuario2.setContrasenia("nro1-2024");
		usuario2.setEstado(true);

		Usuario usuario3 = (Usuario) appContext.getBean("beanUsuario");
		usuario3.setNombreUsuario("JuanMartin");
		usuario3.setContrasenia("zurdoGenio");
		usuario3.setEstado(true);

		// agregar a la base llamar bean
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");

		boolean pivot = usuarioNegocio.add(usuario1);
		pivot = usuarioNegocio.add(usuario2);
		pivot = usuarioNegocio.add(usuario3);
		
		System.out.println("\n ----- usuarios -----");
		List<Usuario> usuarios = usuarioNegocio.readAll();
		usuarios.forEach(System.out::println);
//
/*Horario medico*/		
		
		HorarioTrabajo horarioMedico1 =  (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
		horarioMedico1.setDia("lunes");
		horarioMedico1.setHorario("12:00-1800 ");
		
		HorarioTrabajo horarioMedico2 =  (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
		horarioMedico2.setDia("jueves");
		horarioMedico2.setHorario("13:00-1600");
		
		HorarioTrabajo horarioMedico3 =  (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
		horarioMedico3.setDia("lunes");
		horarioMedico3.setHorario("13:00-1600");
		
/*Medico*/
		
		Medico medico1 = (Medico) appContext.getBean("beanMedico");
		medico1.setApellido("gerez");
		medico1.setNombre("daniel");
		medico1.setCorreoElectronico("fasdf@sfdsd");
		medico1.setDireccion("garibal 232");
		medico1.setEspecialidad(especialidad4);
		medico1.addHorario(horarioMedico1);
		medico1.setUsuario(usuario3);
		medico1.setEstado(true);
		
		Medico medico2 = (Medico) appContext.getBean("beanMedico");
		medico2.setApellido("chavez");
		medico2.setNombre("jose");
		medico2.setCorreoElectronico("fasdf@sfdsd");
		medico2.setDireccion("garibal 232");
		medico2.setEspecialidad(especialidad2);
		/*medico2.addHorario(horarioMedico1);*/ //error de key duplicada
		medico2.addHorario(horarioMedico2);
		medico2.addHorario(horarioMedico3);
		medico2.setUsuario(usuario2);
		medico2.setEstado(true);

		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");

		estado = medicoNegocio.exist(1);
		
		if (estado == false) {
			estado = medicoNegocio.add(medico1);
		} else {
			System.out.println("ya existe medico");
		}
		
		estado = medicoNegocio.exist(2);

		if (estado == false) {
			estado = medicoNegocio.add(medico2);
		} else {
			System.out.println("ya existe medico");
		}
		System.out.println("\n ----- medicos -----");
		List<Medico> listaMedico = medicoNegocio.readAll();
		for (Medico medico : listaMedico) {
			System.out.println(medico);
		}
			
	//turnos
		
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

		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
		boolean boolTurno1 = turnoNegocio.add(turno1);
		boolean boolTurno2 = turnoNegocio.add(turno2);
		
		System.out.println("\n ----- turnos -----");
		List<Turno> listaTurno = turnoNegocio.readAll();
		listaTurno.forEach(System.out::println);
		
//    	
		medico1.setEstado(false);
		medicoNegocio.update(medico1);
		System.out.println("\n medico " + medico1.getLegajo() + " con estado false");
		
		System.out.println("\n ----- medicos activos-----");
		List<Medico> listaMedicoActivos = medicoNegocio.readAllActive();
		for (Medico medico : listaMedicoActivos) {
			System.out.println("id medico= " + medico.getLegajo());
		}
		
		
		
		((ClassPathXmlApplicationContext) appContext).close();

	
	}

}
