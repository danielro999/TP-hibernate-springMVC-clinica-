package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Especialidad;
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
		
		medicoNegocio.add(medico);
		
		((ClassPathXmlApplicationContext) appContext).close();
		mav.setViewName("index");
		return mav;
	}
	
	
}
