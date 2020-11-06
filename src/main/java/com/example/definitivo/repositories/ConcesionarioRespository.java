package com.example.definitivo.repositories;

import com.example.definitivo.entities.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//El integer es el id de la bbdd -> la primary key
@Repository
public interface ConcesionarioRespository extends JpaRepository<Concesionario, Integer> {

}
