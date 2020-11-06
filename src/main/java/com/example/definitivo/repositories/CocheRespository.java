package com.example.definitivo.repositories;

import com.example.definitivo.entities.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRespository  extends JpaRepository<Coche, Integer> {
}
