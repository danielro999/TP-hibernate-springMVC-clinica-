package frgp.utn.edu.ar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.HorarioTrabajo;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;

@Controller
public class HorarioTrabajoController {
	
	
	
	@RequestMapping(value="irAltaHorarios.html")
	public ModelAndView irAltaHorario (@RequestParam("id") int legajo) {
        ModelAndView mav = new ModelAndView();
        ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
        Medico medico = medicoNegocio.readOne(legajo);
        
        List<HorarioTrabajo> horariosTrabajo = new ArrayList<HorarioTrabajo>();
        Map<String, Boolean> horarios =  new HashMap<>();
        horariosTrabajo	= medico.getListaHorarioTrabajo();
        for (HorarioTrabajo horarioTrabajo : horariosTrabajo) {
        	
        	 String hora1 = horarioTrabajo.getLunes();
        	 horarios.put("lunes_"+ hora1, true);
        	 String hora2 = horarioTrabajo.getMartes();
        	 horarios.put("martes_"+ hora2, true);
		}
        System.out.println(horarios);
        mav.addObject("horarios", horarios);
        mav.addObject("medico", medico);
        mav.setViewName("alta_horario");
        
        return mav;
	}
	
	

}
