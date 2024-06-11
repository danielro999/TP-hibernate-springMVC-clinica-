package frgp.utn.edu.ar.dao;

import java.util.List;


import frgp.utn.edu.ar.entidad.Usuario;

public interface IdaoUsuario {
	public boolean add(Usuario usuario);
	public Usuario readOne(String nombreEspecialidad);
	public List<Usuario> readAll();
	public boolean exist(String nombreEspecialidad);
	public boolean update(Usuario usuario);
	public boolean delete(Usuario usuario);

}
