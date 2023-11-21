package com.driver.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.domain.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
