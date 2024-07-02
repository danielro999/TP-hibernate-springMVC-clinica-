package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

@Controller
@SessionAttributes("usuarioLogin")
public class LoginController {
	
	@RequestMapping("ValidarUsuario.html")
	public ModelAndView ValidarUsuario(String txtUsuario, String txtPass) {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");

		  String valorStr ="";
		Usuario confirmado=usuarioNegocio.validarUsuario(txtUsuario, txtPass);
		if(confirmado !=null)
		{
			
			mav.addObject("usuarioLogin",confirmado);
			mav.setViewName("index");
		}else {
			Usuario valor= new Usuario();
			valor.setNombreUsuario("no usario");
			valor.setId((long)0);
			//valor.setEstado(true);
			valorStr="Ingresar Usuario";
			mav.addObject("usuarioLogin",valor);
			valorStr="USUARIO O CLAVE INCORRECTA.";
			
			System.out.println(valor);
		}
		mav.addObject("usuario",valorStr); 
		mav.setViewName("loginUsuario");
		
		((ClassPathXmlApplicationContext) appContext).close();
		return mav;
	}

	@RequestMapping("paginaLogin.html")
	public ModelAndView paginaLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginUsuario");
		return mav;
	}
	
	@RequestMapping("paginaLoginSalir.html")
	public ModelAndView paginaLoginSalir() {
		ModelAndView mav = new ModelAndView();
		Usuario usuarioNull= new Usuario();
		mav.addObject("usuarioLogin",usuarioNull);
		mav.setViewName("loginUsuario");
		return mav;
	}


}
