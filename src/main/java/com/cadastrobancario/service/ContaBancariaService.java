package com.cadastrobancario.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService {

	@Autowired
	private ContaBancariaRepository contabancariaRepository;

	public List<ContaBancaria> listarContaBancaria() {
		return contabancariaRepository.findAll();

	}

	public Optional<ContaBancaria> buscarPorId(Long id) {
		return contabancariaRepository.findById(id);

	}

	public ContaBancaria salvar(ContaBancaria contabancaria) {
		Date data = new Date();
		Random random = new Random(data.getTime());

		Long numero = random.nextLong();

		contabancaria.setNumerodaconta(numero.toString());
		return contabancariaRepository.save(contabancaria);

	}

	public ContaBancaria atualizar(Long Id, ContaBancaria contabancariaSalvar) {
		ContaBancaria contabancariaVaiSerAtualizada = validarContaBancariaExiste(Id);
		BeanUtils.copyProperties(contabancariaSalvar, contabancariaVaiSerAtualizada, "id");
		return contabancariaRepository.save(contabancariaVaiSerAtualizada);

	}

	public void deletar(Long id) {
		contabancariaRepository.deleteById(id);

	}

	private ContaBancaria validarContaBancariaExiste(Long id) {
		Optional<ContaBancaria> contabancaria = buscarPorId(id);
		if (contabancaria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return contabancaria.get();
	}

}
