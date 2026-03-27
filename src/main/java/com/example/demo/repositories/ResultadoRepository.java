package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Muestra;
import com.example.demo.models.Resultado;
import com.example.demo.models.TipoResultado;

public interface ResultadoRepository extends JpaRepository <Resultado, Long>{
	
	List<Resultado> findByTipoResultado(TipoResultado tipoResultado);
	List<Resultado> findByFechaInicio(LocalDate fechaInicio);
}
