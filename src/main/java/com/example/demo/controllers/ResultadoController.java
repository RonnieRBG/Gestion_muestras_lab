package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.Resultado;
import com.example.demo.models.TipoResultado;
import com.example.demo.services.ResultadoService;


@RestController
@RequestMapping("/resultados")
public class ResultadoController {

	@Autowired
	private ResultadoService resultadoService;
	
	@GetMapping
	public List<Resultado> listar() {
		
		return resultadoService.listarResultados();
	}
	
	@GetMapping ("/{id}")
	public Resultado buscarPorId (@PathVariable Long id) {
		return resultadoService.buscarPorId(id);
	}
	
	@GetMapping ("/tipoResultado")
	public List<Resultado> buscarPorTipoResultado (@RequestParam TipoResultado tipoResultado) {
		return  resultadoService.buscarPorTipoResultado(tipoResultado);
	}
	
	@GetMapping("/fechaInicio")
	public List<Resultado> buscarPorFechaInicio(@RequestParam LocalDate fechaInicio) {
	    return resultadoService.buscarPorFechaInicio(fechaInicio);
	}
	
	  @PostMapping
	    // @PreAuthorize("hasRole('ADMIN')")
	    public Resultado crear(@RequestBody Resultado resultado) {
	        return resultadoService.guardarResultado(resultado);
	    }
	  
	  @DeleteMapping ("/{id}")
	  public void eliminarResultado (@PathVariable Long id) {
		  
		  resultadoService.eliminarResultado(id); 
	  }
}


