package frgp.utn.edu.ar.negocioImp;
import java.util.List;

import frgp.utn.edu.ar.dao.IdaoTurno;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.negocio.ITurnoNegocio;




public class TurnoNegocio implements ITurnoNegocio {

    // Necesario para Spring Core
    private IdaoTurno daoTurno;

    public TurnoNegocio() {

    }

    public TurnoNegocio(IdaoTurno daoTurno) {
        this.daoTurno = daoTurno;
       
    }

    public IdaoTurno getDaoTurno() {
        return daoTurno;
    }

    public void setDaoTurno(IdaoTurno daoTurno) {
        this.daoTurno = daoTurno;
    }

    // Hasta aquí: Necesario para Spring Core

    public boolean add(Turno turno) {
        return daoTurno.add(turno);
    }

    public Turno readOne(Long id) {
        return daoTurno.readOne(id);
    }

    public List<Turno> readAll() {
        return daoTurno.readAll();
    }

    public boolean update(Turno turno) {
        return daoTurno.update(turno);
    }

    public boolean delete(Turno turno) {
        return daoTurno.delete(turno);
    }


}