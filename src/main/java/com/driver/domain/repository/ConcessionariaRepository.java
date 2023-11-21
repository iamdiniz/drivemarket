package com.driver.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.domain.model.Concessionaria;

@Repository
public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {

}
