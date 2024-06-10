package frgp.utn.edu.ar.negocioImp;
import java.util.List;

import frgp.utn.edu.ar.dao.IdaoPaciente;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.negocio.IPacienteNegocio;

public class PacienteNegocio implements IPacienteNegocio {

    // Necesario para Spring Core
    private IdaoPaciente daoPaciente;

    public PacienteNegocio() {

    }

    public PacienteNegocio(IdaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public IdaoPaciente getDaoPaciente() {
        return daoPaciente;
    }

    public void setDaoPaciente(IdaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    // Hasta aquí: Necesario para Spring Core

    public boolean add(Paciente paciente) {
        return daoPaciente.add(paciente);
    }

    public Paciente readOne(Long id) {
        return daoPaciente.readOne(id);
    }

    public List<Paciente> readAll() {
        return daoPaciente.readAll();
    }

    public boolean update(Paciente paciente) {
        return daoPaciente.update(paciente);
    }

    public boolean delete(Paciente paciente) {
        return daoPaciente.delete(paciente);
    }
}