package com.example.definitivo.respository;

import com.example.definitivo.entity.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//El integer es el id de la bbdd
@Repository
public interface ConcesionarioRespository extends JpaRepository<Concesionario, Integer> {
}
