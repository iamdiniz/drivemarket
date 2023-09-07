package com.driver.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.domain.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
