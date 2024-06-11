package frgp.utn.edu.ar.daoImp;
import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoTurno;
import frgp.utn.edu.ar.entidad.Turno;



public class DaoTurno implements IdaoTurno{
	

	
	    private Conexion conexion;

	    public DaoTurno() {
	    }

	    public DaoTurno(Conexion conexion) {
	        this.conexion = conexion;
	    }

	    public boolean add(Turno turno) {
	        boolean estado = true;
	        Session session = null;

	        try {
	            session = conexion.abrirConexion();
	            session.beginTransaction();

	            // Guardar el objeto
	            session.save(turno);
	            // Guardar el objeto
	            session.save(turno);

	            // Forzar la sincronización de la sesión con la base de datos
	            session.flush();

	            // Confirmar la transacción
	            session.getTransaction().commit();

	            // Verificar si el objeto se agregó a la base de datos
	            Turno savedTurno = (Turno) session.get(Turno.class, turno.getId());

	            if (savedTurno == null) {
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

	    public Turno readOne(int id) {
	        Session session = conexion.abrirConexion();
	        session.beginTransaction();
	        Turno turno = (Turno) session.get(Turno.class, id);
	        return turno;
	    }

	    public boolean update(Turno turno) {
	        boolean estado = true;
	        Session session = null;

	        try {
	            session = conexion.abrirConexion();
	            session.beginTransaction();

	            // Guardar el objeto
	            session.update(turno);

	            // Forzar la sincronización de la sesión con la base de datos
	            session.flush();

	            // Confirmar la transacción
	            session.getTransaction().commit();

	            // Verificar si el objeto se agregó a la base de datos
	            Turno savedTurno = (Turno) session.get(Turno.class, turno.getId());

	            if (!savedTurno.equals(turno)) {
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

	    public boolean delete(Turno turno) {
	        boolean estado = true;
	        Session session = null;

	        try {
	            session = conexion.abrirConexion();
	            session.beginTransaction();

	            // Guardar el objeto
	            session.delete(turno);

	            // Forzar la sincronización de la sesión con la base de datos
	            session.flush();

	            // Confirmar la transacción
	            session.getTransaction().commit();

	            // Verificar si el objeto se agregó a la base de datos
	            Turno savedTurno = (Turno) session.get(Turno.class, turno.getId());

	            if (savedTurno != null) {
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

	    public List<Turno> readAll() {
	        Session session = conexion.abrirConexion();
	        session.beginTransaction();
	        List<Turno> turno = session.createQuery("FROM Turno").list();
	        return turno;
	    }

	    // Agrego los getters y setters para Spring Core

	    public Conexion getConexion() {
	        return conexion;
	    }

	    public void setConexion(Conexion conexion) {
	        this.conexion = conexion;
	    }

		@Override
		public Turno readOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	       