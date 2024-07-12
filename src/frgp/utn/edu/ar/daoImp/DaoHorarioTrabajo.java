package frgp.utn.edu.ar.daoImp;

import org.hibernate.Query;
import org.hibernate.Session;
import frgp.utn.edu.ar.dao.IdaoHorarioTrabajo;
import frgp.utn.edu.ar.entidad.HorarioTrabajo;


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
        // Ejecutar la consulta y obtener el resultado único
        HorarioTrabajo horariosTrabajo = (HorarioTrabajo) query.uniqueResult();
        return horariosTrabajo;
	}

	
}
