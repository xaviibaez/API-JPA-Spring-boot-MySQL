package com.example.definitivo.repositories;

import com.example.definitivo.entities.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRespository  extends JpaRepository<Coche, Integer> {
    Void save(Optional<Coche> cocheToUpdate);
    List<Coche> findByIdConcesionario(Integer idConcesionario);
    List<Coche> findByIdConcesionarioOrderByFechaIngreso(Integer idConcesionario);
    List<Coche> findByIdConcesionarioOrderByFechaVenta(Integer idConcesionario);
}
