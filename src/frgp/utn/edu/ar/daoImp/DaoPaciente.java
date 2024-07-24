package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoPaciente;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;

public class DaoPaciente implements IdaoPaciente {

    private Conexion conexion;

    public DaoPaciente() {
    }

    public DaoPaciente(Conexion conexion) {
        this.conexion = conexion;
    }

    public boolean add(Paciente paciente) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.save(paciente);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getId());

            if (savedPaciente == null) {
                estado = false;
            }

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        	session.close();
        }

        return estado;
    }

    public Paciente readOne(Long id) {
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        Paciente paciente = (Paciente) session.get(Paciente.class, id);
        return paciente;
    }
    

    public boolean update(Paciente paciente) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.update(paciente);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getId());

            if (!savedPaciente.equals(paciente)) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        	session.close();
        }
        

        return estado;
    }

    public boolean delete(Paciente paciente) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.delete(paciente);

            // Forzar la sincronización de la sesión con la base de datos
            session.flush();

            // Confirmar la transacción
            session.getTransaction().commit();

            // Verificar si el objeto se agregó a la base de datos
            Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getId());

            if (savedPaciente != null) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        	session.close();
        }

        return estado;
    }

    public List<Paciente> readAll() {
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Paciente> pacientes = session.createQuery("FROM Paciente").list();
        return pacientes;
    }
    public List<Paciente> readAllActive() {
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Paciente> pacientes = session.createQuery("FROM Paciente where estado= 1").list();
        return pacientes;
    }
    
    public boolean exiteDNI(String dni) {
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        String hql = "FROM Paciente WHERE dni = :dni";
        Query query = session.createQuery(hql);
        query.setParameter("dni", dni);

        // Ejecutar la consulta y obtener el resultado �nico
        Paciente pacienteConDni = (Paciente) query.uniqueResult();

        //de profe
        //Especialidad especialidad = (Especialidad) session.get(Especialidad.class, nombreEspecialidad);
  
        return pacienteConDni==null? false : true ;
    }
    
    // Agrego los getters y setters para Spring Core

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
}