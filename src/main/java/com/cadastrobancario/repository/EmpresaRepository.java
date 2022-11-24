package com.cadastrobancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrobancario.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
