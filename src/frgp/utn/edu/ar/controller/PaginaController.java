package frgp.utn.edu.ar.controller;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

@Controller
public class PaginaController {
	public UsuarioNegocio usuarioNegocio;
	
/*	public void init (ServletConfig config) {
		ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		this.usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
	}
*/

	@RequestMapping("paginaIndex.html")
	public ModelAndView paginaInicio() {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
		mav.addObject("especialidades", especialidadNegocio.readAll());
		mav.setViewName("index");
		((ClassPathXmlApplicationContext) appContext).close();

		return mav;
	}



}
