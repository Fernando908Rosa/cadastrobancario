package com.cadastrobancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrobancario.entity.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {

}
