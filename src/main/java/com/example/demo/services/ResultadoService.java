package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;


import com.example.demo.models.Resultado;
import com.example.demo.models.TipoResultado;

public interface ResultadoService {

	  	public Resultado guardarResultado(Resultado resultado);
	    public List<Resultado> listarResultados();
	    public Resultado buscarPorId(Long id);
	    public List<Resultado> buscarPorTipoResultado(TipoResultado tipoResultado);
	    public List<Resultado> buscarPorFechaInicio(LocalDate fechaInicio);
	    void eliminarResultado(Long id);
}
