package com.cadastrobancario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.repository.ContaBancariaRepository;

@Service
public class SaldoService {

	@Autowired
	private ContaBancariaRepository contaBancariaRepository;

	public Optional<ContaBancaria> buscarPorId(Long id) {
		return contaBancariaRepository.findById(id);

	}
}
