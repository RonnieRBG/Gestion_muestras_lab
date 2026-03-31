package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.models.Resultado;
import com.example.demo.models.TipoResultado;
import com.example.demo.repositories.MuestraRepository;
import com.example.demo.repositories.ResultadoRepository;

import jakarta.transaction.Transactional;
//esta primera version no contiene el actrualizar

@Service
public class ResultadoServiceImpl implements ResultadoService {
	
	@Autowired
		ResultadoRepository resultadoRepository;
	@Autowired
		MuestraRepository muestraRepository;
	
	
	@Override
	@Transactional
	public Resultado guardarResultado(Resultado resultado) {
		
		// Hacemos primero verificaciones para la muestra, que exista y que no sea nula.
		// recordar que para validar 
		
		if (resultado.getMuestra() == null || resultado.getMuestra().getId() == null) {
	        throw new ValidationException("Debe enviar una muestra con un ID válido para guardar el resultado");
	    }
		
		Long verificarMuestra = resultado.getMuestra().getId();
		muestraRepository.findById(verificarMuestra).orElseThrow(() -> new NotFoundException("La muestra con ID " + verificarMuestra + " no existe en la base de datos"));		
		 
		//Se obtienen primero los resultados y se limpian
		String estado = resultado.getEstado();
		if (estado != null) {
		    estado = estado.trim(); 
		    resultado.setEstado(estado);
		    
		}
		    
		String valor = resultado.getValor();
		if (valor != null) {
		    valor = valor.trim();
		    resultado.setValor(valor);
		
		    }
		    		
		if (resultado.getEstado() == null || resultado.getEstado().isEmpty()) {
		    throw new ValidationException("Por favor ingrese ESTADO");
		    
		}
			
		if (!estado.equalsIgnoreCase("PENDIENTE") && !estado.equalsIgnoreCase("FINALIZADO")) {
		    throw new ValidationException("El estado debe ser PENDIENTE o FINALIZADO");
		        
		}
					
		// Validacion para que el resultado no quede vacio si el estado es PENDIENTE.
		if (resultado.getEstado().equalsIgnoreCase("PENDIENTE")) {
			if (resultado.getValor() != null && !resultado.getValor().isEmpty()) {
				throw new ValidationException("NO se puede guardar el valor del resultado mientras el estado sea PENDIENTE");
				
				}
		}
		
		//Validacion para que el resultado no quede vacio al pasar a finalizado
		if (resultado.getEstado().equalsIgnoreCase("FINALIZADO")) {
			if (resultado.getValor() == null || resultado.getValor().isEmpty()) {
				throw new ValidationException("El valor es obligatorio si el estado es FINALIZADO");
				
				}
		}
				     
		//  Validcion que fechaInicio exista de manera obligatoria
		if (resultado.getFechaInicio() == null) {
			throw new ValidationException("La fecha de inicio es obligatoria");
			
		}
			
		//Validacion para que la fecha de finalizacion sea mayor a fecha inicio 
		if (resultado.getFechaFin() != null) {
			if (resultado.getFechaFin().isBefore(resultado.getFechaInicio())) {
				throw new ValidationException("La fecha fin no puede ser menor que la fecha inicio");
				
				}
	    }
	    
	   
	    
	    //Guardar si todo está OK
	    return resultadoRepository.save(resultado);
}

	@Override
	public List<Resultado> listarResultados() {
		
		return resultadoRepository.findAll();
	}
	
	//Aqui tenia un problema ya que aunque no se encontraba la muestra la api mandaba un resultado vacio como si existiera
	//asi que simplemente se manera la exepcion si la muestra existe te la manda si no manda la excepcion

	@Override
	public Resultado buscarPorId(Long id) {
		
		return resultadoRepository.findById(id).orElseThrow(() -> new NotFoundException("Resultado no encontrado"));  //resultadoRepository.findById(id).orElse(null)
			
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
