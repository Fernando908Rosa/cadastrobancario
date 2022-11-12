package com.cadastrobancario.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	public ContaBancaria validandoContaBancaria(DepositoRequestDto depositoDto) {
		return contabancariaRepository.findByAgenciaAndNumerodaconta(depositoDto.getAgencia(),
				depositoDto.getNumerodaconta());

	}

	public void realizandoDeposito(ContaBancaria buscarContaBancaria, @Valid DepositoRequestDto depositDto)
			throws Exception {
		if (buscarContaBancaria.getId() == null) {
			throw new Exception("Erro, nao foi realizado o deposito");

		}
	}

	public void salvandoExtrato(ContaBancaria buscarContaBancaria, @Valid DepositoRequestDto depositDto) {
		extratoService.salvar(new Extrato(depositDto.getSaldo(), depositDto.getTitulo(), depositDto.getDescricao(),
				Transacao.DEPOSITO, new ContaBancaria(buscarContaBancaria.getId())));
	}

	public ContaBancaria realizandoDeposito(@Valid DepositoRequestDto depositDto) throws Exception {

		ContaBancaria buscarContaBancaria = validandoContaBancaria(depositDto);
		realizandoDeposito(buscarContaBancaria, depositDto);

		salvandoExtrato(buscarContaBancaria, depositDto);
		return efetuadoDeposito(buscarContaBancaria, depositDto);

	}

	private ContaBancaria efetuadoDeposito(ContaBancaria buscarContaBancaria, @Valid DepositoRequestDto depositDto) {
		depositDto.setSaldo(buscarContaBancaria.getSaldo().add(depositDto.getSaldo()));
		BeanUtils.copyProperties(depositDto, buscarContaBancaria, "id");

		return contabancariaRepository.save(buscarContaBancaria);

	}

}
