package frgp.utn.edu.ar.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.HorarioTrabajo;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocioImp.HorarioTrabajoNegocio;
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
        horariosTrabajo	= medico.getListaHorarioTrabajo();
//       for (HorarioTrabajo horarioTrabajo : horariosTrabajo) {
//		System.out.println(horarioTrabajo);
//	}
//        Map<String, Boolean> horarios =  new HashMap<>();
//        int cont = 9;
//        for (HorarioTrabajo horarioTrabajo : horariosTrabajo) {
//        	System.out.println(cont);
//        	 String hora =String.valueOf(cont);
//        	 horarios.put("lunes_"+ hora, horarioTrabajo.isLunes());
//        	 horarios.put("martes_"+ hora, horarioTrabajo.isMartes());
//        	 horarios.put("miercoles_"+ hora, horarioTrabajo.isMiercoles());
//        	 horarios.put("jueves_"+ hora, horarioTrabajo.isJueves());
//        	 horarios.put("viernes_"+ hora, horarioTrabajo.isViernes());
//        	 horarios.put("sabado_"+ hora, horarioTrabajo.isSabado());
//        	 horarios.put("domingo_"+ hora, horarioTrabajo.isDomingo());
//        	 cont+=1;
//		}
//        System.out.println(horarios);
        
        mav.addObject("horarios", horariosTrabajo);
        mav.addObject("medico", medico);
        mav.setViewName("alta_horario");
        ((ClassPathXmlApplicationContext) appContext).close();
        return mav;
	}
	


	@RequestMapping(value="altaHorarios.html")
	public ModelAndView altaHorario(@RequestParam("horarios") String horariosStr,int legajo)  {
		ModelAndView mv = new ModelAndView();
        ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		HorarioTrabajoNegocio horarioTrabajoNegocio = (HorarioTrabajoNegocio) appContext.getBean("beanHorarioTrabajoNegocio");
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		Medico medico = medicoNegocio.readOne(legajo);
		int IdInicialHoracios= medico.getListaHorarioTrabajo().get(0).getId();
       
		List<Boolean> horarios = new ArrayList<>();
		String[] valores = null;
        if (horariosStr != null && !horariosStr.isEmpty()) {
            valores = horariosStr.split(",");
            System.out.println(Arrays.toString(valores));

            for (String valor : valores) {
                horarios.add("1".equals(valor));
            }
            System.out.println(Arrays.toString(valores));
        }

		int cont=0;
		for (int i = 0; i < 14; i++) {
			
			HorarioTrabajo horarioMedico1 = horarioTrabajoNegocio.readOne(IdInicialHoracios);
			horarioMedico1.setLunes(horarios.get(cont));
			horarioMedico1.setMartes(horarios.get(++cont));
			horarioMedico1.setMiercoles(horarios.get(++cont));
			horarioMedico1.setJueves(horarios.get(++cont));
			horarioMedico1.setViernes(horarios.get(++cont));
			horarioMedico1.setSabado(horarios.get(++cont));
			horarioMedico1.setDomingo(horarios.get(++cont));
			cont++;
			IdInicialHoracios++;
			horarioTrabajoNegocio.update(horarioMedico1);	
		}
		
        ((ClassPathXmlApplicationContext) appContext).close();
		mv.addObject("id", legajo);
		mv.setViewName("redirect:/irAltaHorarios.html");
		return mv;
		
	}

}
