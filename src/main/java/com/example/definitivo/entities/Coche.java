package com.example.definitivo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String marca;
    private Float coste;
    private Date fechaVenta;
    private Date fechaIngreso;
    private Boolean vendido;
    private String matricula;
    private Float precioVenta;
    private Integer idConcesionario;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Float getCoste() {
        return coste;
    }

    public void setCoste(Float coste) {
        this.coste = coste;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(Integer idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
