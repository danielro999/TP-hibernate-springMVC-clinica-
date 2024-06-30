package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Medico;

public interface IMedicoNegocio {
	
	public boolean add(Medico medico);
	public Medico readOne(int legajo);
	public List<Medico> readAll();
    public List<Medico> readAllActive(); 
	public boolean exist(int id);
	public boolean update(Medico medico);
	public boolean delete(Medico medico);
	public List<Medico> filtarEspecialidad(String especialidad); 

}
