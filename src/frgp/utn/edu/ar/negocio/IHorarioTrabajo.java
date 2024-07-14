package frgp.utn.edu.ar.negocio;

import frgp.utn.edu.ar.entidad.HorarioTrabajo;

public interface IHorarioTrabajo {
	public HorarioTrabajo readOne(int id);
	public boolean update(HorarioTrabajo horarioTrabajo);
}
