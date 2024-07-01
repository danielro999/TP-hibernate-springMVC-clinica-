package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;


@Controller
public class UsuarioController {
	private Medico medico=new Medico();
	
	@RequestMapping("irAltaUsuario.html")
	public ModelAndView irAltaUsuario(String apellido, String nombre, String correoElectronico, String direccion,
			boolean estado, String fechaNacimiento, String localidad, String sexo, String telefono,
			String especialidad) {

		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");

		this.medico.setApellido(apellido);
		this.medico.setNombre(nombre);
		this.medico.setCorreoElectronico(correoElectronico);
		this.medico.setDireccion(direccion);
		this.medico.setEstado(estado);
		this.medico.setFechaNacimiento(fechaNacimiento);
		this.medico.setLocalidad(localidad);
		this.medico.setSexo(sexo);
		this.medico.setTelefono(telefono);
		this.medico.setEspecialidad(especialidadNegocio.readOne(especialidad));

		((ClassPathXmlApplicationContext) appContext).close();
		mav.addObject("medico", medico);
		mav.setViewName("alta_usuario");
		return mav;
	}

	@RequestMapping("altaUsuario.html")
	public ModelAndView altaUsuario(String nombre_usuario, String contrasenia, boolean estado, boolean admin
		) {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
		usuario.setNombreUsuario(nombre_usuario);
		usuario.setContrasenia(contrasenia);
		usuario.setEstado(estado);
		usuario.setAdmin(admin);

		medico.setUsuario(usuario);

		medicoNegocio.add(this.medico);

		((ClassPathXmlApplicationContext) appContext).close();

		mav.setViewName("index");
		return mav;
	}

}
