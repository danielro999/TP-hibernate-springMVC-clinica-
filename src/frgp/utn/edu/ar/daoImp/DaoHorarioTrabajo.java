package frgp.utn.edu.ar.daoImp;

import org.hibernate.Query;
import org.hibernate.Session;
import frgp.utn.edu.ar.dao.IdaoHorarioTrabajo;
import frgp.utn.edu.ar.entidad.HorarioTrabajo;
import frgp.utn.edu.ar.entidad.Medico;


public class DaoHorarioTrabajo implements IdaoHorarioTrabajo {

	private Conexion conexion;

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public DaoHorarioTrabajo() {
		super();
	}
	
	public HorarioTrabajo readOne(int id) {
		Session session = conexion.abrirConexion();
        session.beginTransaction();
       System.out.println(id);
        String hql = "FROM HorarioTrabajo WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        // Ejecutar la consulta y obtener el resultado 鷑ico
        HorarioTrabajo horariosTrabajo = (HorarioTrabajo) query.uniqueResult();
        return horariosTrabajo;
	}

    public boolean update(HorarioTrabajo horarioTrabajo) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.merge(horarioTrabajo);

            // Forzar la sincronizaci贸n de la sesi贸n con la base de datos
            session.flush();

            // Confirmar la transacci贸n
            session.getTransaction().commit();

            // Verificar si el objeto se agreg贸 a la base de datos
            HorarioTrabajo savedHorarioTrabajo = (HorarioTrabajo) session.get(HorarioTrabajo.class, horarioTrabajo.getId());

            if (!savedHorarioTrabajo.equals(horarioTrabajo)) {
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

    
	
}
