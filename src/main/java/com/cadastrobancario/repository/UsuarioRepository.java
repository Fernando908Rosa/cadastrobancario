package com.cadastrobancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrobancario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
