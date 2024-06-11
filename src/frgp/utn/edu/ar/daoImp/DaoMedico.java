package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import frgp.utn.edu.ar.dao.IdaoMedico;
import frgp.utn.edu.ar.entidad.Medico;

public class DaoMedico implements IdaoMedico {

    private Conexion conexion;

    public DaoMedico() {
    }

    public DaoMedico(Conexion conexion) {
        this.conexion = conexion;
    }

	public boolean exist(int legajo) {
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medico medico=(Medico)session.get(Medico.class,legajo);
        if(medico!=null)
        	return true;
        
        return false;
	}
    
    public boolean add(Medico medico) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.save(medico);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Medico savedMedico = (Medico) session.get(Medico.class, medico.getLegajo());

            if (savedMedico == null) {
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

    
	public Medico readOne(String nombreMedico) {
		Session session = conexion.abrirConexion();
        session.beginTransaction();
       
        String hql = "FROM Especialidad WHERE nombre = :nombre";
        Query query = session.createQuery(hql);
        query.setParameter("nombre", nombreMedico);

        // Ejecutar la consulta y obtener el resultado �nico
        Medico medico = (Medico) query.uniqueResult();

        //de profe
        //Especialidad especialidad = (Especialidad) session.get(Especialidad.class, nombreEspecialidad);

        return medico;
	}
    
    public boolean update(Medico medico) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.update(medico);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Medico savedMedico = (Medico) session.get(Medico.class, medico.getLegajo());

            if (!savedMedico.equals(medico)) {
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

    public boolean delete(Medico medico) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.delete(medico);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Medico savedMedico = (Medico) session.get(Medico.class, medico.getLegajo());

            if (savedMedico != null) {
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

    public List<Medico> readAll() {
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Medico> Medico = session.createQuery("FROM Medico").list();
        return Medico;
    }

    // Agrego los getters y setters para Spring Core

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    
//  public Medico readOne(Long legajo) {
//  Session session = conexion.abrirConexion();
//  session.beginTransaction();
//  Medico medico = (Medico) session.get(Medico.class, legajo);
//  return medico;
//}

}