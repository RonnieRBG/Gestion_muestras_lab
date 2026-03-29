package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private TipoResultado tipoResultado;   // RAM, HYL, EC, EB, STX
    private String valor;           // Positivo, Negativo, Ausencia, Presencia, .

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private String estado;          // En proceso, Finalizado, Pendiente

    @ManyToOne
    @JoinColumn(name = "muestra_id")
    @JsonBackReference
    private Muestra muestra;

    public Resultado() {
    }

    public Long getId() {
        return id;
    }

    public TipoResultado getTipoResultado() {
        return tipoResultado;
    }

    public String getValor() {
        return valor;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public Muestra getMuestra() {
        return muestra;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipoResultado(TipoResultado tipoResultado) {
        this.tipoResultado = tipoResultado;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }
}