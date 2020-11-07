package com.example.definitivo.repositories;

import com.example.definitivo.entities.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
* Lista de metodos y querys para acceder a la bbdd
 */
@Repository
public interface CocheRespository  extends JpaRepository<Coche, Integer> {
    Void save(Optional<Coche> cocheToUpdate);
    List<Coche> findByIdConcesionario(Integer idConcesionario);
    List<Coche> findByIdConcesionarioOrderByFechaIngreso(Integer idConcesionario);
    List<Coche> findByIdConcesionarioOrderByFechaVenta(Integer idConcesionario);

    @Query("SELECT SUM(c.precioVenta)-SUM(c.coste) FROM Coche c WHERE c.idConcesionario = ?1")
    Float beneficiosConcesionario(Integer idConcesionario);
    @Query("SELECT SUM(c.precioVenta)-SUM(c.coste) FROM Coche c ")
    Float beneficiosCadena();

}
