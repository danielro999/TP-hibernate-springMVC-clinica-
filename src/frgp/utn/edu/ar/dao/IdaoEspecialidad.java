package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Especialidad;

public interface IdaoEspecialidad {
	public boolean add(Especialidad especialidad);
	public Especialidad readOne(String nombreEspecialidad);
	public List<Especialidad> readAll();
	public boolean exist(long id);
	public boolean update(Especialidad especialidad);
	public boolean delete(Especialidad especialidad);

}
