package frgp.utn.edu.ar.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;

public class Main {

	public static void main(String[] args) {


		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");

	
		
//		Usuario user= new Usuario();
//		
//		user = UsNeg.readOne("BELA");
		System.out.println(especialidadNegocio.readAll());
	//	System.out.println(user.getContrasenia());

		((ClassPathXmlApplicationContext) appContext).close();

	
	}

}
