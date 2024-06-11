package frgp.utn.edu.ar.negocioImp;

import java.util.List;


import frgp.utn.edu.ar.dao.IdaoMedico;
import frgp.utn.edu.ar.daoImp.DaoMedico;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocio.IMedicoNegocio;



public class MedicoNegocio implements IMedicoNegocio {

	private IdaoMedico daoMedico;
	
	public MedicoNegocio()
	{
		
	}
	public MedicoNegocio(DaoMedico daoMedico)
	{
		this.daoMedico = daoMedico;
	}
	
	public IdaoMedico getDaoMedico() {
		return daoMedico;
	}
	public void setDaoMedico(IdaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}
	
	
	//metodos
	
	public boolean add(Medico medico) {
		return daoMedico.add(medico);
	}

	
	public Medico readOne(String nombreMedico) {
		//return daoUsuario.ReadOne(nombreUsuario);
		return daoMedico.readOne(nombreMedico);
	}

	
	public List<Medico> readAll() {
		
		return daoMedico.readAll();
	}

	
	public boolean exist(int id) {

		return daoMedico.exist(id);
	}

	
	public boolean update(Medico medico) {
		
		return daoMedico.update(medico);
	}

	
	public boolean delete(Medico medico) {
	
		return daoMedico.delete(medico);
	}
	
	public IdaoMedico getDao() {
		return daoMedico;
	}
	public void setDao(IdaoMedico dao) {
		this.daoMedico = dao;
	}
}
