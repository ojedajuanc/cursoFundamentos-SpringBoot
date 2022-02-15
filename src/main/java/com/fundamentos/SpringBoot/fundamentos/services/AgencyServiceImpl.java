package com.fundamentos.SpringBoot.fundamentos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.Agency;

@Service

public class AgencyServiceImpl {
	// Esta clase implementa directamente la interfaz AgencyRepository
	// No extiende de una interfaz AgencyService

	private final CrudRepository<Agency, Long> repository;

	public AgencyServiceImpl(CrudRepository<Agency, Long> repository) {
		this.repository = repository;
		this.repository.saveAll(defaultAgencies());
	}

	private static List<Agency> defaultAgencies() {
		return List.of(new Agency("Buenos Aires", (long) 1, "info.ba@agency.com"),
				new Agency("Salta", (long) 0002, "info.salta@agency.com"),
				new Agency("Córdoba", (long) 0003, "info.cordoba@agency.com"),
				new Agency("Mendoza", (long) 0004, "info.mendoza@agency.com"),
				new Agency("Corrientes", (long) 0005, "info.ctes@agency.com"));
	}
	
	public List<Agency> findAll(){
		List<Agency> list = new ArrayList<>();
		Iterable<Agency> agencies = repository.findAll();
		agencies.forEach(list::add);
		return list;
	}
	
	public Optional<Agency> findById(Long id){
		return repository.findById(id);
	}
	
	public Agency addAgency(Agency agency) {
		return repository.save(agency);
	}
	
	public Optional<Agency> update(Long id, Agency updatedAgency){
		return repository.findById(id)
				.map(agency -> {
					agency.setInternalCode(updatedAgency.getInternalCode());
					agency.setContactEmail(updatedAgency.getContactEmail());
					return repository.save(agency);
				});
	}
	
	public void deleteAgency(Long id) {
		repository.deleteById(id);
	}

}
