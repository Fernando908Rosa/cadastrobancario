package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.repository.ContaBancariaRepository;

@Service
public class DepositoService {

	@Autowired
	private ContaBancariaRepository contabancariaRepository;

	public List<ContaBancaria> listarContaBancaria() {
		return contabancariaRepository.findAll();

	}

	public Optional<ContaBancaria> buscarPorId(Long id) {
		return contabancariaRepository.findById(id);

	}

	public ContaBancaria salvar(ContaBancaria contabancaria) throws Exception {
		ContaBancaria agencia = contabancariaRepository.findByAgenciaAndNumerodaconta(contabancaria.getAgencia(),
				contabancaria.getNumerodaconta());

		if (agencia.getId() == null) {
			throw new Exception("Erro, nao foi realizado o deposito");

		}
		BeanUtils.copyProperties(contabancaria, agencia, "id");

		return contabancariaRepository.save(agencia);

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
