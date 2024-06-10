package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.daoImp.DaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.negocio.IEspecialidadNegocio;



public class EspecialidadNegocio implements IEspecialidadNegocio {

	private IdaoEspecialidad daoEspecialidad;
	
	public EspecialidadNegocio()
	{
		
	}
	public EspecialidadNegocio(DaoEspecialidad daoEspecialidad)
	{
		this.daoEspecialidad = daoEspecialidad;
	}
	
	public IdaoEspecialidad getDaoEspecialidad() {
		return daoEspecialidad;
	}
	public void setDaoEspecialidad(IdaoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
	}
	
	
	//metodos
	
	public boolean add(Especialidad especialidad) {
		return daoEspecialidad.add(especialidad);
	}

	
	public Especialidad readOne(String nombreEspecialidad) {
		//return daoUsuario.ReadOne(nombreUsuario);
		return daoEspecialidad.readOne(nombreEspecialidad);
	}

	
	public List<Especialidad> readAll() {
		//return daoUsuario.ReadAll();
		return daoEspecialidad.readAll();
	}

	
	public boolean exist(long id) {
		//return daoUsuario.Exist(nombreUsuario);
		return daoEspecialidad.exist(id);
	}

	
	public boolean update(Especialidad especialidad) {
		//return daoUsuario.Update(usuario);
		return daoEspecialidad.update(especialidad);
	}

	
	public boolean delete(Especialidad especialidad) {
		//return daoUsuario.Delete(usuario);
		return daoEspecialidad.delete(especialidad);
	}
	
	//aca me perdiiiiiiiiiiiii______________________________
	public IdaoEspecialidad getDao() {
		return daoEspecialidad;
	}
	public void setDao(IdaoEspecialidad dao) {
		this.daoEspecialidad = dao;
	}
}
