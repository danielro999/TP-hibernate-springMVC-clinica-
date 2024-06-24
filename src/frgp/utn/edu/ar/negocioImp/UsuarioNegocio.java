package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.dao.IdaoUsuario;
import frgp.utn.edu.ar.daoImp.DaoEspecialidad;
import frgp.utn.edu.ar.daoImp.DaoUsuario;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocio.IUsuarioNegocio;

public class UsuarioNegocio implements IUsuarioNegocio {
	
	//variable
	private IdaoUsuario daoUsuario;
	//constructores
	public UsuarioNegocio() {
		
	}
	
	public UsuarioNegocio(DaoUsuario daoUsurario) {
		
		this.daoUsuario = daoUsurario;
	}
	
	//get y set  de Interfaz ???????????????
	public IdaoUsuario getDaoUsuario() {
		return daoUsuario;
	}
	public void setDaoUsuario(IdaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	

	public boolean add(Usuario usuario) {
		return daoUsuario.add(usuario);
	}

	
	public Usuario readOne(String nombreUsuario) {
		return daoUsuario.readOne(nombreUsuario);
	}


	public List<Usuario> readAll() {
		return daoUsuario.readAll();
	}

	
	public boolean exist(String nombreUsuario) {
		return daoUsuario.exist(nombreUsuario);
	}


	public boolean update(Usuario usuario) {
		return daoUsuario.update(usuario);
	}

	
	public boolean delete(Usuario usuario) {
		return daoUsuario.delete(usuario);
	}
	
	//esto que es -------------------------------es el nombre del bean ???????
		public IdaoUsuario getDao() {
			return daoUsuario;
		}

		public void setDao(IdaoUsuario dao) {
			this.daoUsuario = dao;
		}

		@Override
		public List<Usuario> readAllActive() {
			return daoUsuario.readAllActive();
		}

}
