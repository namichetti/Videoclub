package com.videoclub.videoclubNestor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.videoclubNestor.entity.Socio;
import com.videoclub.videoclubNestor.service.ISocioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins={"http://localhost:4200"})
public class SocioController {

	@Autowired
	private ISocioService socioService;
	
	@GetMapping("/socios")
	public List<Socio> getListaSocio(){
		return this.socioService.getAllSocio();
	}
	
	@GetMapping("/socios/{id}")
	public ResponseEntity<?> getSocio(@PathVariable Long id){
		Socio socio = null;	
		Map<String,Object> response = new HashMap<>();
		
		try {
			socio = this.socioService.getSocioById(id);		
		}catch(DataAccessException e) {			
			response.put("mensaje","Error al acceder al socio en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		if(socio == null)
		{
			response.put("mensaje", "El socio no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Socio>(socio,HttpStatus.OK);
	}
	
}
