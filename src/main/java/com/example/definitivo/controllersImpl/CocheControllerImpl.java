package com.example.definitivo.controllersImpl;

import com.example.definitivo.controllers.CocheController;
import com.example.definitivo.entities.Coche;
import com.example.definitivo.repositories.CocheRespository;
import com.example.definitivo.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CocheControllerImpl implements CocheController {

    @Autowired
    CocheService cocheService;

    // http://localhost:8080/coches (GET)
    @RequestMapping(value = "/coches", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Coche> getCoches() {
        return cocheService.findAllCoches();
    }

    @Override
    public Optional<Coche> getCocheById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Coche addCoche(Coche cocheNew) {
        return null;
    }

    @Override
    public String deleteCoche(Integer id) {
        return null;
    }

    @Override
    public String updateCoche(Coche cocheUpdated) {
        return null;
    }

    @Override
    public String test() {
        return null;
    }
}
