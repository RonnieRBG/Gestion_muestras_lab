package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Muestra;

public interface MuestraRepository extends JpaRepository <Muestra, Long>{

	List<Muestra> findByItem(String item);
	List<Muestra> findByLote(String lote);
}
