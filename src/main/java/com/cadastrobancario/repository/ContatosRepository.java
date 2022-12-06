package com.cadastrobancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrobancario.entity.Contato;

public interface ContatosRepository extends JpaRepository<Contato, Long> {

}
