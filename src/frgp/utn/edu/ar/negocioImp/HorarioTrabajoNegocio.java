package frgp.utn.edu.ar.negocioImp;

import frgp.utn.edu.ar.dao.IdaoHorarioTrabajo;
import frgp.utn.edu.ar.entidad.HorarioTrabajo;
import frgp.utn.edu.ar.negocio.IHorarioTrabajo;

public class HorarioTrabajoNegocio implements IHorarioTrabajo{
	private IdaoHorarioTrabajo daoHorarioTrabajo;
	
	public HorarioTrabajoNegocio() {
		super();
	}

	public IdaoHorarioTrabajo getDaoHorarioTrabajo() {
		return daoHorarioTrabajo;
	}

	public void setDaoHorarioTrabajo(IdaoHorarioTrabajo daoHorarioTrabajo) {
		this.daoHorarioTrabajo = daoHorarioTrabajo;
	}
	public boolean update(HorarioTrabajo horarioTrabajo) {
		return daoHorarioTrabajo.update(horarioTrabajo);
	}
	public HorarioTrabajo readOne(int id) {
		return daoHorarioTrabajo.readOne(id);
	}

}
