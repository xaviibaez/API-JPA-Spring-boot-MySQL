package com.example.definitivo.servicesImpl;

public class CocheNotFoundException extends RuntimeException {

    CocheNotFoundException(Integer id) {
        super("Could not find car: " + id);
    }
}
