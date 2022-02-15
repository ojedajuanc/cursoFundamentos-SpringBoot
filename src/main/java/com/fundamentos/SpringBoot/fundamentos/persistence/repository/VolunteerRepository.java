package com.fundamentos.SpringBoot.fundamentos.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.Volunteer;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{

}
