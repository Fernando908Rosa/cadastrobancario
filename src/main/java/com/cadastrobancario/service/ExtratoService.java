package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.Extrato;
import com.cadastrobancario.repository.ExtratoRepository;

@Service
public class ExtratoService {

	@Autowired
	private ExtratoRepository extratoRepository;

	public List<Extrato> LitarExtrato() {
		return extratoRepository.findAll();

	}

	public Optional<Extrato> buscarPorId(Long id) {
		return extratoRepository.findById(id);

	}

	public Extrato salvar(Extrato extrato) {
		return extratoRepository.save(extrato);

	}

	public Extrato atualizar(Long Id, Extrato extratoSalvar) {
		Extrato extratoVaiSerAtualizado = validarExtratoExiste(Id);
		BeanUtils.copyProperties(extratoSalvar, extratoVaiSerAtualizado, "id");
		return extratoRepository.save(extratoVaiSerAtualizado);

	}

	public void deletar(Long id) {
		extratoRepository.deleteById(id);
	}

	private Extrato validarExtratoExiste(Long id) {
		Optional<Extrato> extrato = buscarPorId(id);
		if (extrato.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return extrato.get();

	}

}
