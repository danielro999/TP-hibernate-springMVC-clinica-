package frgp.utn.edu.ar.negocio;



import java.util.List;

import frgp.utn.edu.ar.entidad.Paciente;

public interface IPacienteNegocio {

    boolean add(Paciente paciente);
    Paciente readOne(Long id);
    List<Paciente> readAll();
    boolean update(Paciente paciente);
    boolean delete(Paciente paciente);
}