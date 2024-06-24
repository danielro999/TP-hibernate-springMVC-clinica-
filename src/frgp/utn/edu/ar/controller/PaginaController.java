package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

@Controller
public class PaginaController {
	@RequestMapping("rediccionar_pag2.html")
	public ModelAndView evetoRedireccinarPag2(String txtNombre, int txtEdad) {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
		mav.addObject("nombre", txtNombre);
		mav.addObject("edad", txtEdad);
		mav.addObject("usuario", usuarioNegocio.readOne("BELA").getContrasenia());
		mav.setViewName("pagina2");
		return mav;
	}
	
	@RequestMapping("paginaIndex.html")
	public ModelAndView paginaInicio() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("redireccionar_pag3.html")
	public ModelAndView evetoRedireccinarPag3(String txtUsuario, String txtPass) {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
		
		String valor;
		Usuario confirmado=usuarioNegocio.validarUsuario(txtUsuario, txtPass);
		if(confirmado !=null)
		{
			valor=confirmado.getNombreUsuario();
		}else {
			valor="Usuario o clave incorrecta";
		}
		
		mav.addObject("usuario",valor); 
		mav.setViewName("loginUsuario");
		return mav;
	}
	

}
