package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.Contato;
import com.cadastrobancario.repository.ContatosRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatosRepository contatosRepository;

	public List<Contato> listarTodoContato() {
		return contatosRepository.findAll();

	}

	public Optional<Contato> buscarContatoPorId(Long id) {
		return contatosRepository.findById(id);
	}

	public Contato salvar(Contato contato) {
		return contatosRepository.save(contato);

	}

	public Contato atualizar(Long Id, Contato contatoSalvo) {
		Contato contatoVaiSerAtualizado = validarContatoExistente(Id);
		BeanUtils.copyProperties(contatoSalvo, contatoVaiSerAtualizado, "id");
		return contatosRepository.save(contatoVaiSerAtualizado);
	}

	public void deletar(Long id) {
		contatosRepository.deleteById(id);
	}

	private Contato validarContatoExistente(Long id) {
		Optional<Contato> contato = buscarContatoPorId(id);
		if (contato.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return contato.get();
	}

}
