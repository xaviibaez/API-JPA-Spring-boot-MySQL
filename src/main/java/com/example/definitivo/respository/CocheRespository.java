package com.example.definitivo.respository;

import com.example.definitivo.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRespository  extends JpaRepository<Coche, Integer> {
}
