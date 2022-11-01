package com.cadastrobancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrobancario.entity.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

}
