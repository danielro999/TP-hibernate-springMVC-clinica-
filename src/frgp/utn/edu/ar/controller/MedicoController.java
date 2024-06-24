package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		ModelAndView mav = new ModelAndView();
		mav.setViewName("alta_medicos");
		return mav;
	}
	
	@RequestMapping("altaMedico.html")
	public ModelAndView altaMedico(
	        String apellido,
	        String nombre,
	        String correoElectronico,
	        String direccion,
	        int estado,
	        String fechaNacimiento ,
	        String localidad,
	        String sexo,
	        String telefono,
	        String especialidad) 
	{
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		System.out.println(apellido + " " +  correoElectronico + " "+estado);
		((ClassPathXmlApplicationContext) appContext).close();
		mav.setViewName("index");
		return mav;
	}
	
	
}
