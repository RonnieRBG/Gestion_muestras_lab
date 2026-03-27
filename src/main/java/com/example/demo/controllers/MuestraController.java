package com.example.demo.controllers;

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

import com.example.demo.models.Muestra;
import com.example.demo.services.MuestraService;

@RestController
@RequestMapping("/muestras")
public class MuestraController {
	
	@Autowired
	private MuestraService muestraService;
	
	@GetMapping
	public List<Muestra> listar() {
		
		return muestraService.listarMuestras();
	}
	
	@GetMapping ("/{id}")
	public Muestra buscarPorId (@PathVariable Long id) {
		return muestraService.buscarPorId(id);
	}
	
	@GetMapping ("/item")
	public List<Muestra> buscarPorItem (@RequestParam String item) {
		return  muestraService.buscarPorItem(item);
	}
	
	@GetMapping("/lote")
	public List<Muestra> buscarPorLote(@RequestParam String lote) {
	    return muestraService.buscarPorLote(lote);
	}
	
	  @PostMapping
	    // @PreAuthorize("hasRole('ADMIN')")
	    public Muestra crear(@RequestBody Muestra muestra) {
	        return muestraService.guardarMuestra(muestra);
	    }
	  
	  @DeleteMapping ("/{id}")
	  public void eliminarMuestra (@PathVariable Long id) {
		  
		  muestraService.eliminarMuestra(id); 
	  }
}
