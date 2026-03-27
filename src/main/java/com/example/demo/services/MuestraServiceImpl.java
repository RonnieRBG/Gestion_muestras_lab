package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Muestra;
import com.example.demo.repositories.MuestraRepository;


@Service
public class MuestraServiceImpl implements MuestraService{

	@Autowired
		MuestraRepository muestraRepository;
	
	@Override
	public Muestra guardarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		return muestraRepository.save(muestra);
	}

	@Override
	public List<Muestra> listarMuestras() {
		// TODO Auto-generated method stub
		return muestraRepository.findAll();
	}

	@Override
	public Muestra buscarPorId(Long id) {
		 return muestraRepository.findById(id).orElse(null);
	}

	private Object obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Muestra> buscarPorItem(String item) {
		// TODO Auto-generated method stub
		return muestraRepository.findByItem(item);
	}

	@Override
	public List<Muestra> buscarPorLote(String lote) {
		// TODO Auto-generated method stub
		return muestraRepository.findByLote(lote);
	}

	@Override
	public void eliminarMuestra(Long id) {
		 muestraRepository.deleteById(id);
	}
		
	}

	
	

