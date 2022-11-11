package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.dto.DepositoRequestDto;
import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.entity.Extrato;
import com.cadastrobancario.enuns.Transacao;
import com.cadastrobancario.repository.ContaBancariaRepository;

@Service
public class DepositoService {

	@Autowired
	private ContaBancariaRepository contabancariaRepository;

	@Autowired
	private ExtratoService extratoService;

	public List<ContaBancaria> listarContaBancaria() {
		return contabancariaRepository.findAll();

	}

	public Optional<ContaBancaria> buscarPorId(Long id) {
		return contabancariaRepository.findById(id);

	}

	public ContaBancaria salvar(@Valid DepositoRequestDto depositoDto) throws Exception {
		ContaBancaria buscaContaBancaria = contabancariaRepository
				.findByAgenciaAndNumerodaconta(depositoDto.getAgencia(), depositoDto.getNumerodaconta());

		if (buscaContaBancaria.getId() == null) {
			throw new Exception("Erro, nao foi realizado o deposito");

		}
		extratoService.salvar(new Extrato(depositoDto.getSaldo(), depositoDto.getTitulo(), depositoDto.getDescricao(),
				Transacao.DEPOSITO, new ContaBancaria(buscaContaBancaria.getId())));

		depositoDto.setSaldo(buscaContaBancaria.getSaldo().add(depositoDto.getSaldo()));
		BeanUtils.copyProperties(depositoDto, buscaContaBancaria, "id");

		return contabancariaRepository.save(buscaContaBancaria);

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
