package com.fundamentos.SpringBoot.fundamentos.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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

import com.fundamentos.SpringBoot.fundamentos.VolunteerNotFoundException;
import com.fundamentos.SpringBoot.fundamentos.persistence.entity.Volunteer;
import com.fundamentos.SpringBoot.fundamentos.services.VolunteerServiceImpl;

@RestController
@RequestMapping("api/volunteers")
public class VolunteerController {
	
	private VolunteerServiceImpl service;
	
	
	
	public VolunteerController(VolunteerServiceImpl service) {
		this.service = service;
	}

	/*@GetMapping("/")
	public ResponseEntity<List<Volunteer>> getAll(){
		List<Volunteer> volunteersList = service.findAll();
		return new ResponseEntity<List<Volunteer>>(volunteersList, HttpStatus.OK);
	}*/
	
	@GetMapping("/")
	public CollectionModel<EntityModel<Volunteer>> getAll(){
		List<EntityModel<Volunteer>> volunteersList = service.findAll()
				.stream()
				.map(volunteer -> EntityModel.of(volunteer, 
						linkTo(methodOn(VolunteerController.class).getVolunteer(volunteer.getId())).withSelfRel(),
						linkTo(methodOn(VolunteerController.class).getAll()).withRel("volunteers")))
						.collect(Collectors.toList());
						
						
		return CollectionModel.of(volunteersList, linkTo(methodOn(VolunteerController.class).getAll()).withSelfRel());
	}
	
	/*@GetMapping("/{id}")
	public Volunteer getVolunteer(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new VolunteerNotFoundException(id));
	}*/
	
	@GetMapping("/{id}")
	public EntityModel<Volunteer> getVolunteer(@PathVariable Long id) {
		Volunteer volunteer = service.findById(id).orElseThrow(() -> new VolunteerNotFoundException(id));
		return EntityModel.of(volunteer,
				linkTo(methodOn(VolunteerController.class).getVolunteer(id)).withSelfRel(),
				linkTo(methodOn(VolunteerController.class).getAll()).withRel("volunteers"));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Volunteer> createVolunteer(@RequestBody Volunteer volunteer){
		Volunteer savedVolunteer = service.addVolunteer(volunteer);
		return new ResponseEntity<Volunteer>(savedVolunteer, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<Volunteer>> updateVolunteer(@PathVariable Long id, @RequestBody Volunteer updatedVolunteer){
		Optional<Volunteer> volunteer = service.updateCityAndNameVolunteer(id, updatedVolunteer);
		return new ResponseEntity<Optional<Volunteer>>(volunteer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Volunteer> deleteVolunteer(@PathVariable Long id){
		service.deleteVolunteer(id);
		return new ResponseEntity<Volunteer>(HttpStatus.NO_CONTENT);
	}
	
	

}
