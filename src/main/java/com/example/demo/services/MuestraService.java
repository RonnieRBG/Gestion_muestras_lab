package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Muestra;

public interface MuestraService {
	
    public Muestra guardarMuestra(Muestra muestra);
    public List<Muestra> listarMuestras();
    public Muestra buscarPorId(Long id);
    public List<Muestra> buscarPorItem(String item);
    public List<Muestra> buscarPorLote(String lote);
    void eliminarMuestra(Long id);
}