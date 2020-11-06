package com.example.definitivo.controllers;

import com.example.definitivo.entities.Coche;

import java.util.List;
import java.util.Optional;

public interface CocheController {
    public List<Coche> getCoches();
    public Optional<Coche> getCocheById(Integer id);
    public Coche addCoche(Coche cocheNew);
    public String deleteCoche(Integer id);
    public String updateCoche(Coche cocheUpdated);

    public String test();
}
