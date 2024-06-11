package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoUsuario;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Usuario;

public class DaoUsuario implements IdaoUsuario {
	//variable y constructores
	private Conexion conexion;
	
	public DaoUsuario() {
			
		}
		public DaoUsuario(Conexion conexion) {
			this.conexion = conexion;
		}

	//agregar
	public boolean add(Usuario usuario) {
		boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            // Guardar el objeto
            session.save(usuario);
            // Forzar la sincronización de la sesión con la base de datos
            session.flush();
            // Confirmar la transacción
            session.getTransaction().commit();
            
            // Verificar si el objeto se agregó a la base de datos
            Usuario savedUsuario = (Usuario) session.get(Usuario.class, usuario.getId());

            if (savedUsuario == null) {
                estado = false;
            }

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        }

        return estado;
		
	}

	//Traer un usuario completo
	public Usuario readOne(String nombreUsuario) {
		Session session = conexion.abrirConexion();
        session.beginTransaction();
       
        String hql = "FROM Usuario WHERE nombre = :nombreUsuario";
        Query query = session.createQuery(hql);
        query.setParameter("nombre", nombreUsuario);
        // Ejecutar la consulta y obtener el resultado único
        Usuario usuario = (Usuario) query.uniqueResult();
        return usuario;
	}

	//traer lista de usuraios
	public List<Usuario> readAll() {
		Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("FROM Usuario").list();
        return usuarios;
	}

	//Existe o es repetido
	public boolean exist(String nombreUsuario) {
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		 String hql = "FROM Usuario WHERE nombre = :nombreUsuario";
	        Query query = session.createQuery(hql);
	        query.setParameter("nombre", nombreUsuario);

	        // Ejecutar la consulta y obtener el resultado único
	        Usuario usuario = (Usuario) query.uniqueResult();
       // Especialidad especialidad=(Especialidad)session.get(Especialidad.class,id);
        if(usuario!=null)
        	return true;
  
        return false;
	}

	//modificar
	public boolean update(Usuario usuario) {
		boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.update(usuario);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Usuario savedUsuario = (Usuario) session.get(Usuario.class, usuario.getId());

            if (!savedUsuario.equals(usuario)) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        }

        return estado;
	}

	
	public boolean delete(Usuario usuario) {
		boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.delete(usuario);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Usuario savedUsuario = (Usuario) session.get(Usuario.class, usuario.getId());

            if (savedUsuario != null) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        }

        return estado;
    }
	
	//geter y seters
	public Conexion getConexion() {
		return getConexion();
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
		
	

}
