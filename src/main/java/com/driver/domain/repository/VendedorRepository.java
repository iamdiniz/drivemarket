package com.driver.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.domain.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	Optional<Vendedor> findByCpf(String cpf);
	
	Optional<Vendedor> findByEmail(String email);
	
}
