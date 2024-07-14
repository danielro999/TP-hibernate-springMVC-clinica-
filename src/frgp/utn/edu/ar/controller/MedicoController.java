package frgp.utn.edu.ar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.HorarioTrabajo;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;


@Controller
public class MedicoController {
	@RequestMapping("listarMedicos.html")
	public ModelAndView listarMedicos() {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		mav.addObject("medicos", medicoNegocio.readAll());
		mav.setViewName("listar_medico");
		((ClassPathXmlApplicationContext) appContext).close();
		return mav;
	}
	
	@RequestMapping("cargaMedico.html")
	public ModelAndView cargaMedico() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
		ModelAndView mav = new ModelAndView();
		mav.addObject("especialidades", especialidadNegocio.readAll());
		mav.setViewName("alta_medicos");
		((ClassPathXmlApplicationContext) appContext).close();
		return mav;
	}
	
	@RequestMapping("altaMedico.html")
	public ModelAndView altaMedico(
	        String apellido,
	        String nombre,
	        String correoElectronico,
	        String direccion,
	        boolean estado,
	        String fechaNacimiento ,
	        String localidad,
	        String sexo,
	        String telefono,
	        String especialidad) 
	{
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		Medico medico = (Medico)appContext.getBean("beanMedico");
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");

		medico.setApellido(apellido);
		medico.setNombre(nombre);
		medico.setCorreoElectronico(correoElectronico);
		medico.setDireccion(direccion);
		medico.setEstado(estado);
		medico.setFechaNacimiento(fechaNacimiento);
		medico.setLocalidad(localidad);
		medico.setSexo(sexo);
		medico.setTelefono(telefono);
		medico.setEspecialidad(especialidadNegocio.readOne(especialidad));
		
		
	List <HorarioTrabajo> listaHorasDias = new ArrayList<HorarioTrabajo>();	
	for (int i = 0; i < 14; i++) {
			HorarioTrabajo horarioMedico = (HorarioTrabajo) appContext.getBean("beanHorarioTrabajo");
			horarioMedico.setLunes(false);
			horarioMedico.setMartes(false);
			horarioMedico.setMiercoles(false);
			horarioMedico.setJueves(false);
			horarioMedico.setViernes(false);
			horarioMedico.setSabado(false);
			horarioMedico.setDomingo(false);
			
			listaHorasDias.add(horarioMedico);
	}
	medico.setListaHorarioTrabajo(listaHorasDias);
	medicoNegocio.add(medico);
		
		((ClassPathXmlApplicationContext) appContext).close();
		mav.setViewName("index");
		return mav;
	}
	
	  @RequestMapping("irmodificarMedico.html")
	    public ModelAndView irmodificarPaciente(@RequestParam("id") int legajo) {
	        ModelAndView mav = new ModelAndView();
	        ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	        EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
	        Medico medico = medicoNegocio.readOne(legajo);
	        

	        if (medico != null) {
	            mav.addObject("medico", medico);
	            mav.addObject("especialidades", especialidadNegocio.readAll());
	            mav.setViewName("modificarMedico");
	        } else {
	            mav.setViewName("error"); // Manejo de error si no se encuentra el paciente
	        }

	        ((ClassPathXmlApplicationContext) appContext).close();
	        return mav;
	    }

		@RequestMapping("modificarMedico.html")
		public ModelAndView modificarMedico(
		        int legajo,
				String apellido,
		        String nombre,
		        String correoElectronico,
		        String direccion,
		        boolean estado,
		        String fechaNacimiento ,
		        String localidad,
		        String sexo,
		        String telefono,
		        String especialidad) 
		{
			ModelAndView mav = new ModelAndView();
			ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
			Medico medico = (Medico)appContext.getBean("beanMedico");
			MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
			EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
			medico = medicoNegocio.readOne(legajo);
			
			if (medico != null) {
			medico.setApellido(apellido);
			medico.setNombre(nombre);
			medico.setCorreoElectronico(correoElectronico);
			medico.setDireccion(direccion);
			medico.setEstado(estado);
			medico.setFechaNacimiento(fechaNacimiento);
			medico.setLocalidad(localidad);
			medico.setSexo(sexo);
			medico.setTelefono(telefono);
			medico.setEspecialidad(especialidadNegocio.readOne(especialidad));
			}

			medicoNegocio.update(medico);
			
			((ClassPathXmlApplicationContext) appContext).close();
			mav.setViewName("index");
			return mav;
		}
		
	    @RequestMapping("eliminarMedico.html")
	    public ModelAndView eliminarMedico(@RequestParam("id") int legajo) {
	        ModelAndView mv = new ModelAndView();
	        ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	        Medico medico = medicoNegocio.readOne(legajo);
	        
	        if (medico != null) {
	        	medico.setEstado(false);
	            boolean eliminado = medicoNegocio.update(medico);
	            
	            if (eliminado) {
	                mv.addObject("mensaje", "Medico eliminado exitosamente");
	            } else {
	                mv.addObject("mensaje", "Error al eliminar el medico");
	            }
	        } else {
	            mv.addObject("mensaje", "medico no encontrado");
	        }
	        ((ClassPathXmlApplicationContext) appContext).close();
	        mv.setViewName("index");
	        return mv;
	    }
	
	
	
	
}
