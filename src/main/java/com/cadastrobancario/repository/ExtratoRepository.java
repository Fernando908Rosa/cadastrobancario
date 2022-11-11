package com.cadastrobancario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrobancario.entity.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

	List<Extrato> findByContabancariaId(Long idContaBancaria);

}
