package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Paciente;
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

	@RequestMapping("CargaPaciente.html")
	public ModelAndView cargaPaciente() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("alta_paciente");
		((ClassPathXmlApplicationContext) appContext).close();
		return mav;
	}

/*	@RequestMapping(value = "/validarDni", method = RequestMethod.GET)
	@ResponseBody
	public boolean validarDni(@RequestParam("dni") String dni) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		((ClassPathXmlApplicationContext) appContext).close();
		System.out.println(pacienteNegocio.exiteDNI(dni));
		return pacienteNegocio.exiteDNI(dni);
	}*/

	@RequestMapping("altaPaciente.html")
	public ModelAndView altaPaciente(String nombre, String apellido, String dni, String telefono, String direccion,
			String localidad, String provincia, String fechaNacimiento, String correoElectronico, boolean estado,Model model) {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		
		if (pacienteNegocio.exiteDNI(dni)) {
			mav.addObject("error", "El DNI ya está registrado.");
			mav.setViewName("alta_paciente");
			((ClassPathXmlApplicationContext) appContext).close();
			return mav;
		}
		else {
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setDni(dni);
			paciente.setTelefono(telefono);
			paciente.setDireccion(direccion);
			paciente.setLocalidad(localidad);
			paciente.setProvincia(provincia);
			paciente.setFechaNacimiento(fechaNacimiento);
			paciente.setCorreoElectronico(correoElectronico);
			paciente.setEstado(estado);

			pacienteNegocio.add(paciente);

			((ClassPathXmlApplicationContext) appContext).close();
			mav.setViewName("index");
			return mav;
		}
		
	}

	@RequestMapping("irmodificarPaciente.html")
	public ModelAndView irmodificarPaciente(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");

		Paciente paciente = pacienteNegocio.readOne(id);

		if (paciente != null) {
			mav.addObject("paciente", paciente);
			mav.setViewName("modificarPaciente");
		} else {
			mav.setViewName("error"); // Manejo de error si no se encuentra el paciente
		}

		((ClassPathXmlApplicationContext) appContext).close();
		return mav;
	}

	@RequestMapping("modificarPaciente.html")
	public ModelAndView modificarPaciente(Long id, String nombre, String apellido, String dni, String telefono,
			String direccion, String localidad, String provincia, String fechaNacimiento, String correoElectronico,
			boolean estado) {

		ModelAndView mav = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");

		paciente = pacienteNegocio.readOne(id);

		if (paciente != null) {
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setDni(dni);
			paciente.setTelefono(telefono);
			paciente.setDireccion(direccion);
			paciente.setLocalidad(localidad);
			paciente.setProvincia(provincia);
			paciente.setFechaNacimiento(fechaNacimiento);
			paciente.setCorreoElectronico(correoElectronico);
			paciente.setEstado(estado);
			pacienteNegocio.update(paciente);
		}

		((ClassPathXmlApplicationContext) appContext).close();
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("eliminarPaciente.html")
	public ModelAndView eliminarPaciente(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		Paciente paciente = pacienteNegocio.readOne(id);

		if (paciente != null) {
			paciente.setEstado(false);
			boolean eliminado = pacienteNegocio.update(paciente);

			if (eliminado) {
				mv.addObject("mensaje", "Paciente eliminado exitosamente");
			} else {
				mv.addObject("mensaje", "Error al eliminar el paciente");
			}
		} else {
			mv.addObject("mensaje", "Paciente no encontrado");
		}
		((ClassPathXmlApplicationContext) appContext).close();
		mv.setViewName("index");
		return mv;
	}
}
