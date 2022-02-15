package com.fundamentos.SpringBoot.fundamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fundamentos.SpringBoot.fundamentos.persistence.repository.VolunteerRepository;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.Volunteer;

@Repository
public class VolunteerServiceImpl {
	//Esta clase implementa directamente la interfaz Volunteer Repository
	//No extiende de una interfaz VolunteerService
	
	private VolunteerRepository repository;
	
	
	//Si no se inyecta la dependencia no funciona IoC
	public VolunteerServiceImpl(VolunteerRepository repository) {
		this.repository = repository;
	}

	public List<Volunteer>findAll(){
		return repository.findAll();
	}
	
	public Optional<Volunteer> findById(Long id){
		Optional<Volunteer> volunteer = repository.findById(id);
		return volunteer;
	}
	
	public Volunteer addVolunteer(Volunteer volunteer) {
		return repository.save(volunteer);
	}
	
	public Optional<Volunteer> updateCityAndNameVolunteer(Long id, Volunteer updatedVol){
		return repository.findById(id)
				.map(volunteer -> {
					volunteer.setCityID(updatedVol.getCityID());
					volunteer.setFirstname(updatedVol.getFirstname());
					volunteer.setLastname(updatedVol.getLastname());
					return repository.save(volunteer);
				});
	}
	
	public void deleteVolunteer(Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
}
