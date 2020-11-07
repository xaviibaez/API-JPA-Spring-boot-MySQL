package com.example.definitivo.controllers;

import com.example.definitivo.entities.Coche;

import java.util.List;
import java.util.Optional;

/*
* Se listan los metodos que usaran la API. La implementacion hace la logica.
 */
public interface CocheController {
    public List<Coche> getCoches();
    public Optional<Coche> getCocheById(Integer id);
    public List<Coche> getCocheByIdConcesionario(Integer id, String orderBy);
    public String addCoche(Coche cocheNew);
    public String deleteCoche(Integer id);
    public Float beneficios(Integer idConcesionario);

    public String test();
}
