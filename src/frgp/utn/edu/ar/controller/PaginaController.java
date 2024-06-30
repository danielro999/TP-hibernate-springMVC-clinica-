package frgp.utn.edu.ar.controller;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Usuario;
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

	@RequestMapping("redireccionar_pag3.html")
	public ModelAndView evetoRedireccinarPag3(String txtUsuario, String txtPass) {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");

		String valor;
		Usuario confirmado = usuarioNegocio.validarUsuario(txtUsuario, txtPass);
		if (confirmado != null) {
			valor = confirmado.getNombreUsuario();
		} else {
			valor = "Usuario o clave incorrecta";
		}
		((ClassPathXmlApplicationContext) appContext).close();
		mav.addObject("usuario", valor);
		mav.setViewName("loginUsuario");
		return mav;
	}

	@RequestMapping("paginaLogin.html")
	public ModelAndView paginaLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginUsuario");
		return mav;
	}

}
