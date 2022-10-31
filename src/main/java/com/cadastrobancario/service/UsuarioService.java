package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.Usuario;
import com.cadastrobancario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Long Id, Usuario usuarioSalvar) {
		Usuario usuarioVaiSerAtualizado = validarUsuarioExiste(Id);
		BeanUtils.copyProperties(usuarioSalvar, usuarioVaiSerAtualizado, "id");
		return usuarioRepository.save(usuarioVaiSerAtualizado);

	}

	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}

	private Usuario validarUsuarioExiste(Long id) {
		Optional<Usuario> usuario = buscarPorId(id);
		if (usuario.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuario.get();

	}

}
