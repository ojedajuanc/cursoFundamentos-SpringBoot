package com.fundamentos.SpringBoot.fundamentos.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.UserPost;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost, Long> {

}
