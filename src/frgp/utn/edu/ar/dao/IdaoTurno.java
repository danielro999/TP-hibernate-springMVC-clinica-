package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Turno;


public interface IdaoTurno{


    boolean add(Turno turno);

    Turno readOne(Long id);

    List<Turno> readAll();

    boolean update(Turno turno);

    boolean delete(Turno turno);
}