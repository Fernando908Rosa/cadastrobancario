package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.Endereco;
import com.cadastrobancario.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Endereco> listarTodosEnderecos() {
		return enderecoRepository.findAll();
	}

	public Optional<Endereco> buscarEnderecoPorId(Long id) {
		return enderecoRepository.findById(id);
	}

	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco atualizar(Long Id, Endereco enderecoSalvo) {
		Endereco enderecoVaiSerAtualizado = validarEnderecoExistente(Id);
		BeanUtils.copyProperties(enderecoSalvo, enderecoVaiSerAtualizado, "id");
		return enderecoRepository.save(enderecoVaiSerAtualizado);

	}

	public void deletar(Long id) {
		enderecoRepository.deleteById(id);
	}

	private Endereco validarEnderecoExistente(Long id) {
		Optional<Endereco> endereco = buscarEnderecoPorId(id);
		if (endereco.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return endereco.get();

	}

}
