package com.fundamentos.SpringBoot.fundamentos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.Agency;
import com.fundamentos.SpringBoot.fundamentos.services.AgencyServiceImpl;

@RestController
@RequestMapping("api/sedes")
public class AgencyController {
	
	@Autowired //Inyecta automáticamente la dependencia en el constructor de AgencyController
	private AgencyServiceImpl service;
	
	@GetMapping("/")
	public ResponseEntity<List<Agency>> getAll(){
		List<Agency> agenciesList = service.findAll();
		return new ResponseEntity<List<Agency>>(agenciesList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Agency> getAgency(@PathVariable Long id) {
		Optional<Agency> agency = service.findById(id);
		return ResponseEntity.of(agency);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Agency> addAgency(@RequestBody Agency agency){
		Agency newAgency = service.addAgency(agency);
		return new ResponseEntity<Agency>(newAgency, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<Agency>> updateAgency(@PathVariable Long id, @RequestBody Agency updatedAgency){
		Optional<Agency> agency = service.update(id, updatedAgency);
		return new ResponseEntity<Optional<Agency>>(agency, HttpStatus.OK);	
	}
	
	@DeleteMapping("{id}")
	public void deleteAgency(@PathVariable Long id) {
		service.deleteAgency(id);		
	}

}
