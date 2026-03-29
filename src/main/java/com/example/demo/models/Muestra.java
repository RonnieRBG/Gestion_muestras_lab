package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "muestras")

public class Muestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String item;
    private String lote;

    @OneToMany(mappedBy = "muestra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Resultado> resultados;

    public Muestra() {
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getItem() {
        return item;
    }

    public String getLote() {
        return lote;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}