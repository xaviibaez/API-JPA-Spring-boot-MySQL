package com.example.definitivo.services;

import com.example.definitivo.entities.Coche;

import java.util.List;
import java.util.Optional;

/*
* Lista de metodos que usara la api justo al entrar al programa. La implementacion hace la logica.
 */
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
