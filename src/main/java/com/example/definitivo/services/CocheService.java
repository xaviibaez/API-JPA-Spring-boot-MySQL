package com.example.definitivo.services;

import com.example.definitivo.entities.Coche;

import java.util.List;
import java.util.Optional;

public interface CocheService {
    public List<Coche> findAllCoches();
    public Optional<Coche> findCocheById(Integer id);
    public List<Coche> findCocheByIdConcesionario(Integer id, String orderBy);
    public String saveCoche(Coche cocheNew);
    public String deleteCoche(Integer id);
    public String matricularCoche(Integer id, String matricula);
    public String venderCoche(Integer id, Float precioVenta);
    public Float beneficios(Integer idConcesionario);
}
