package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Usuario;

public interface IUsuarioNegocio {
	public boolean add(Usuario usuario);
	public Usuario readOne(String nombreUsuario);
	public List<Usuario> readAll();
	List<Usuario> readAllActive();
	public boolean exist(String nombreUsuario);
	public boolean update(Usuario usuario);
	public boolean delete(Usuario usuario);

}
