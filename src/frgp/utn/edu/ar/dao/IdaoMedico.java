package frgp.utn.edu.ar.dao;

import java.util.List;
import frgp.utn.edu.ar.entidad.Medico;


	
	public interface IdaoMedico {

		public boolean add(Medico medico);
		public Medico readOne(String medico);
		public List<Medico> readAll();
		public boolean exist(int id);
		public boolean update(Medico medico);
		public boolean delete(Medico medico);
	}

