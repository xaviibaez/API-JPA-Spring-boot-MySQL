package com.example.definitivo.controllers;

import com.example.definitivo.entity.Coche;
import com.example.definitivo.respository.CocheRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CochesController {

    @Autowired
    CocheRespository cocheRepository;

    @GetMapping("/getCoches")
    public List<Coche> getCoches(){
        return cocheRepository.findAll();
    }

}
