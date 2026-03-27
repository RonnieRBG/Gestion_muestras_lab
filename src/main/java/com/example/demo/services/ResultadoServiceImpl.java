package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Resultado;
import com.example.demo.models.TipoResultado;
import com.example.demo.repositories.ResultadoRepository;

@Service
public class ResultadoServiceImpl implements ResultadoService {
	
	@Autowired
		ResultadoRepository resultadoRepository;

	@Override
	public Resultado guardarResultado(Resultado resultado) {
		
		return resultadoRepository.save(resultado);
	}

	@Override
	public List<Resultado> listarResultados() {
		
		return resultadoRepository.findAll();
	}

	@Override
	public Resultado buscarPorId(Long id) {
		
		return resultadoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Resultado> buscarPorTipoResultado(TipoResultado tipoResultado) {
		
		return resultadoRepository.findByTipoResultado(tipoResultado);
	}

	@Override
	public List<Resultado> buscarPorFechaInicio(LocalDate fechaInicio) {
		
		return resultadoRepository.findByFechaInicio(fechaInicio);
	}

	@Override
	public void eliminarResultado(Long id) {
		
		resultadoRepository.deleteById(id);
		
	}

	
}
