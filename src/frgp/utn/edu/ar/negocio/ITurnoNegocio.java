package frgp.utn.edu.ar.negocio;
import java.util.List;
import frgp.utn.edu.ar.entidad.Turno;

public interface ITurnoNegocio {


	    boolean add(Turno turno);

	    Turno readOne(int id);

	    List<Turno> readAll();
	    
	    List<Turno> traerMedicosPorLegajo(int legajo);

	    boolean update(Turno turno);

	    boolean delete(Turno turno);
	}

