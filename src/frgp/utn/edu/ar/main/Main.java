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
		especialidad1.setId((long) 0);
		especialidad1.setNombre("clinico");
		System.out.println(especialidad1);

		Especialidad especialidad2 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad2.setId((long) 0);
		especialidad2.setNombre("pediatrico");
		System.out.println(especialidad2);

		Especialidad especialidad3 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad3.setId((long) 0);
		especialidad3.setNombre("cardiologo");
		System.out.println(especialidad3);

		Especialidad especialidad4 = (Especialidad) appContext.getBean("beanEspecialidad");
		especialidad4.setId((long) 15);
		especialidad4.setNombre("diabetologo");
		System.out.println(especialidad4);

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

		// traer una especilaidad

		Especialidad unaEspecialidad = especialidadNegocio.readOne("cardiologo");

		System.out.println(unaEspecialidad);

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
		System.out.println(paciente1);

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
		System.out.println(paciente2);

		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		boolean agregado = pacienteNegocio.add(paciente1);

		boolean agregado2 = pacienteNegocio.add(paciente2);

		List<Paciente> listaPaciente = pacienteNegocio.readAll();

		for (Paciente paciente0 : listaPaciente) {
			System.out.println(paciente0.getNombre());
		}
		

		// probar
		// _____________________________________________________________________________
		// crear usuario (objetos)
		Usuario usuario1 = (Usuario) appContext.getBean("beanUsuario");
		// usuario1.setId((long) 1);
		usuario1.setNombreUsuario("BELA");
		usuario1.setContrasenia("elmasgrande");
/*		usuario1.setMedico(null);
*/
		Usuario usuario2 = (Usuario) appContext.getBean("beanUsuario");
		// usuario1.setId((long) 1);
		usuario2.setNombreUsuario("Tapia");
		usuario2.setContrasenia("nro1-2024");
/*		usuario2.setMedico(null);
*/
		Usuario usuario3 = (Usuario) appContext.getBean("beanUsuario");
		usuario3.setNombreUsuario("JuanMartin");
		usuario3.setContrasenia("zurdoGenio");
/*		usuario3.setMedico(medico1);
*/
		// agregar a la base llamar bean
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");

		boolean pivot = usuarioNegocio.add(usuario1);
		pivot = usuarioNegocio.add(usuario2);
		pivot = usuarioNegocio.add(usuario3);

		List<Usuario> usuarios = usuarioNegocio.readAll();
		usuarios.forEach(System.out::println);
//
/*Horario medico*/		
		
		HorarioTrabajo horarioMedico1 =  (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
		horarioMedico1.setDia("lunes");
		horarioMedico1.setHorario("12:00-1800 ");
		System.out.println(horarioMedico1);
		
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
		
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		medicoNegocio.add(medico1);
		medicoNegocio.add(medico2);
		estado = medicoNegocio.exist(1);
		
		if (estado == false) {
			estado = medicoNegocio.add(medico1);
		} else {
			System.out.println("ya existe medico");
		}
		
		if (estado == false) {
			estado = medicoNegocio.add(medico2);
		} else {
			System.out.println("ya existe medico");
		}
		
		

		List<Medico> listaMedico = medicoNegocio.readAll();
		for (Medico medico : listaMedico) {
			System.out.println(medico.getHorarioTrabajo());
			System.out.println(medico.getUsuario());
		}
		
		
	//turnos
		
		Turno turno1 = (Turno) appContext.getBean("beanTurno");
		
		//turno1.setMedico(medico1); // Suponiendo que ya tienes medico1 instanciado
		turno1.setPaciente(paciente1); // Suponiendo que ya tienes paciente1 instanciado
		turno1.setFecha("2024-06-10");
		turno1.setHora("10:00");
		turno1.setObservacion("Consulta rutinaria");
		turno1.setEstado("Confirmado");
		turno1.setMedico(medico1);

		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
		boolean agregado1 = turnoNegocio.add(turno1);
		
		
		List<Turno> listaTurno = turnoNegocio.readAll();
		
		System.out.println(listaTurno);
		
		// for (Turno Turno0 : listaTurno) {
	      //   System.out.println(Turno0.getId());
	     //}
		
		((ClassPathXmlApplicationContext) appContext).close();

		/*
		 * 
		 * // pacinete
		 * 
		 * 
		 * 
		 * 
		 * //ELIMINAR DE MANERA LOGICA EL PACIENTE
		 * 
		 * 
		 * ApplicationContext appContext3 = new
		 * ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		 * DaoPaciente daoPaciente = (DaoPaciente)
		 * appContext3.getBean("beanDaoPaciente"); Scanner scanner = new
		 * Scanner(System.in);
		 * System.out.print("Ingrese el ID del paciente a eliminar: "); Long idPaciente
		 * = scanner.nextLong(); Paciente paciente = daoPaciente.readOne(idPaciente); if
		 * (paciente != null) { // Realizar la eliminación lógica boolean
		 * eliminacionExitosa = daoPaciente.delete(paciente); if (eliminacionExitosa) {
		 * System.out.println("Paciente eliminado correctamente."); } else {
		 * System.out.println("Error al eliminar el paciente."); } } else {
		 * System.out.println("No se encontró ningún paciente con el ID proporcionado."
		 * ); }
		 * 
		 * // Cerrar el scanner y el contexto de Spring scanner.close();
		 * ((ClassPathXmlApplicationContext) appContext3).close();
		 * 
		 * 
		 * 
		 * // LISTAR PACIENTES
		 * 
		 * ApplicationContext appContext4 = new
		 * ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		 * DaoPaciente daoPaciente1 = (DaoPaciente)
		 * appContext4.getBean("beanDaoPaciente"); List<Paciente> pacientes =
		 * daoPaciente.readAll(); for (Paciente paciente2 : pacientes) {
		 * System.out.println(paciente2); } ((ClassPathXmlApplicationContext)
		 * appContext4).close(); }
		 * 
		 */
	}

}
