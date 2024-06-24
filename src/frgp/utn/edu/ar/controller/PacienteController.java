package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.negocioImp.PacienteNegocio;

@Controller
public class PacienteController {
	@RequestMapping("listarPaciente.html")
	public ModelAndView evetoRedireccinarPag2() {
		ModelAndView mav = new ModelAndView();
	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		mav.addObject("pacientes", pacienteNegocio.readAll());
		mav.setViewName("listar_paciente");
		((ClassPathXmlApplicationContext) appContext).close();
		return mav;
	}
	
}

