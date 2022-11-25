package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.Contatos;
import com.cadastrobancario.repository.ContatosRepository;

@Service
public class ContatosService {

	@Autowired
	private ContatosRepository contatosRepository;

	public List<Contatos> listarTodosContatos() {
		return contatosRepository.findAll();

	}

	public Optional<Contatos> buscarContatosPorId(Long id) {
		return contatosRepository.findById(id);
	}

	public Contatos salvar(Contatos contatos) {
		return contatosRepository.save(contatos);

	}

	public Contatos atualizar(Long Id, Contatos contatosSalvos) {
		Contatos contatosVaiSerAtualizados = validarContatosExistentes(Id);
		BeanUtils.copyProperties(contatosSalvos, contatosVaiSerAtualizados, "id");
		return contatosRepository.save(contatosVaiSerAtualizados);
	}

	public void deletar(Long id) {
		contatosRepository.deleteById(id);
	}

	private Contatos validarContatosExistentes(Long id) {
		Optional<Contatos> contatos = buscarContatosPorId(id);
		if (contatos.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return contatos.get();
	}

}
