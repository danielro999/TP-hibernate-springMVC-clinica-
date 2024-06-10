package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Especialidad;

public interface IEspecialidadNegocio {
	
	public boolean add(Especialidad especilidad);
	public Especialidad readOne(String nombreEspecialidad);
	public List<Especialidad> readAll();
	public boolean exist(long id);
	public boolean update(Especialidad especialidad);
	public boolean delete(Especialidad especialidad);

}
