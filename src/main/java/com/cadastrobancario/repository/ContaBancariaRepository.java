package com.cadastrobancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrobancario.entity.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

	ContaBancaria findByAgenciaAndNumerodaconta(Long agencia, String numerodaconta);

}
