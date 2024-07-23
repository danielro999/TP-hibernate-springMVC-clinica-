
package frgp.utn.edu.ar.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.entidad.HorarioTrabajo;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;

@Controller
public class TurnoController {
	@RequestMapping("ListarTurnos.html")
	public ModelAndView evetoRedireccinarTurnos() {
		ModelAndView mav = new ModelAndView();
	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
		mav.addObject("turnos",turnoNegocio.readAll());
	
		mav.setViewName("listar_turnos");
		((ClassPathXmlApplicationContext) appContext).close();
		return mav;
	}
	
	  
	 @RequestMapping("cargaTurno.html")
	    public ModelAndView cargaTurno(String especialidad) {
		 System.out.println(especialidad);
	        ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	        PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("medicos", medicoNegocio.filtarEspecialidad(especialidad));
	        mav.addObject("pacientes", pacienteNegocio.readAll());
	        mav.setViewName("alta_turno");
	        ((ClassPathXmlApplicationContext) appContext).close();
	        return mav;
	 
	 }
	 @RequestMapping("irmodificarTurno.html")
	    public ModelAndView irmodificarTurno(@RequestParam("id") int id) {
	        ModelAndView mav = new ModelAndView();
	        
	        ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	        TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
	        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	        PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	        Turno turno = turnoNegocio.readOne(id);
	     
	        
	        if (turno != null) {
	        	
	            mav.addObject("turno", turno);
	            mav.addObject("medicos", medicoNegocio.readAll());
	            mav.addObject("pacientes", pacienteNegocio.readAll());
	            mav.setViewName("modificarTurno");
	        } else {
	        	 System.out.println("Turno no encontrado, redirigiendo a página de error");
	            mav.setViewName("error"); // Manejo de error si no se encuentra el paciente
	        }
	        
	        ((ClassPathXmlApplicationContext) appContext).close();
	        return mav;
	    }
	 
	 @RequestMapping("modificarTurno.html")
	 public ModelAndView modificarTurno(
			  int id,
		      int Legajo,
	          Long pacienteId,
	          String fecha,
	          String hora,
	          String observacion,
	          String estado) {

	     ModelAndView mav = new ModelAndView();
	     ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	     Turno turno = (Turno) appContext.getBean("beanTurno");
	     TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
	     MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	     PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");

	     turno = turnoNegocio.readOne(id);

	     if (turno != null) {
	         Medico medico = medicoNegocio.readOne(Legajo);
	         Paciente paciente = pacienteNegocio.readOne(pacienteId);
	         
	         turno.setMedico(medico);
	         turno.setPaciente(paciente);
	         turno.setFecha(fecha);
	         turno.setHora(hora);
	         turno.setObservacion(observacion);
	         turno.setEstado(estado);
	         
	         turnoNegocio.update(turno);
	         
	         mav.addObject("medicoApellido", medico.getApellido());
	         mav.addObject("pacienteApellido", paciente.getApellido());
	     }

	     ((ClassPathXmlApplicationContext) appContext).close();
	     mav.setViewName("index");
	     return mav;
	 }
	 
	 @RequestMapping("altaTurno.html")
	 public ModelAndView altaTurno(	   		
		          int Legajo,
		          Long pacienteId,
		          String fecha,
		          String hora,
		          String observacion,
		          String estado) {

	     ModelAndView mav = new ModelAndView();
	     ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	     TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
	     MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	     PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");


	     Turno turno = (Turno) appContext.getBean("beanTurno");

	     turno.setMedico(medicoNegocio.readOne(Legajo));
	     turno.setPaciente(pacienteNegocio.readOne(pacienteId));
	     turno.setFecha(fecha);
	     turno.setHora(hora);
	     turno.setObservacion(observacion);
	     turno.setEstado(estado);

	     boolean isAdded = turnoNegocio.add(turno);

	     if (isAdded) {
	         mav.setViewName("redirect:/ListarTurnos.html");
	     } else {
	        // mav.addObject("error", "No se pudo agregar el turno");
	         //mav.setViewName("index");
	     }

	     ((ClassPathXmlApplicationContext) appContext).close();
	     return mav;
	 }
	 
	 
	 @RequestMapping("ir_diponibilidad.html")
	    public ModelAndView irDiponibilidTurno( 
	    		int legajo,
	    		Long pacienteId,
	    		String fecha,
	    		String dia
	    		) {
	        ModelAndView mav = new ModelAndView();
	        
	        ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	        PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	        TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
	        Medico medico=  medicoNegocio.readOne(legajo);
	        Paciente paciente= pacienteNegocio.readOne(pacienteId);
	        
	        List<Turno> turnos = turnoNegocio.traerMedicosPorLegajo(legajo);
	     
	        List<Integer> listaHoras = new ArrayList<>();
	        
	        for (Turno turno : turnos) {
				if (turno.getFecha().equals(fecha)) {
					listaHoras.add(Integer.valueOf(turno.getHora()));
				}
			}
           
	 /*       for (int i = 0; i < 14; i++) {
				Turno turno = turnos.get(i);
	        	if (turno.getFecha().equals(fecha) && turno.getHora().equals(Integer.toString(i+9))) {
	        		listaFecha.add(false);
	        	} 
	        	else {
	        		listaFecha.add(true);
				}
			}*/
				        
	        System.out.println(listaHoras);
	        
	        List<Boolean> horarios = new ArrayList<>();
	        int cont = 9;
	        for (HorarioTrabajo horario : medico.getListaHorarioTrabajo()) {
	            boolean hora = listaHoras.contains(cont);
	        	if (dia.equals("lunes")){
	        		horarios.add(horario.isLunes() && !hora);
	        	}
	        	if (dia.equals("martes")){
	        		horarios.add(horario.isMartes() && !hora);
	        	}
	        	if (dia.equals("miercoles")){
	        		horarios.add(horario.isMiercoles() && !hora);
	        	}
	        	if (dia.equals("jueves")){
	        		horarios.add(horario.isJueves() && !hora);
	        	}
	           	if (dia.equals("viernes")){
	        		horarios.add(horario.isViernes() && !hora);
	        	}
	           	if (dia.equals("sabado")){
	        		horarios.add(horario.isSabado() && !hora);
	        	}
	           	if (dia.equals("domingo")){
	        		horarios.add(horario.isDomingo() && !hora);
	        	}
	           	cont++;
			}
            mav.addObject("medico", medico);
            mav.addObject("paciente", paciente);
            mav.addObject("fecha", fecha);
            mav.addObject("ListaHorarios", horarios);
            
            mav.setViewName("alta_diponibilidad_turno");
	     
	        ((ClassPathXmlApplicationContext) appContext).close();
	        return mav;
	    }
	 
	 @RequestMapping("eliminarTurno.html")
	 public ModelAndView eliminarTurno(@RequestParam("id") int id) {
	     ModelAndView mv = new ModelAndView();
	     ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	     TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
	     Turno turno = turnoNegocio.readOne(id);

	     if (turno != null) {
	         turno.setEstado("Eliminado");
	         boolean eliminado = turnoNegocio.update(turno);

	         if (eliminado) {
	             mv.addObject("mensaje", "Turno cancelado exitosamente");
	         } else {
	             mv.addObject("mensaje", "Error al cancelar el turno");
	         }
	     } else {
	         mv.addObject("mensaje", "Turno no encontrado");
	     }

	     ((ClassPathXmlApplicationContext) appContext).close();
	     mv.setViewName("redirect:/ListarTurnos.html");
	     return mv;
	 }

	}


