package com.cadastrobancario.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastrobancario.dto.SaqueRequestDto;
import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.entity.Extrato;
import com.cadastrobancario.enuns.Transacao;
import com.cadastrobancario.repository.ContaBancariaRepository;

@Service
public class SaqueService {

	@Autowired
	private ContaBancariaRepository contabancariaRepository;

	@Autowired
	private ExtratoService extratoService;

	public ContaBancaria validaContaBancaria(SaqueRequestDto saqueDto) {
		return contabancariaRepository.findByAgenciaAndNumerodaconta(saqueDto.getAgencia(),
				saqueDto.getNumerodaconta());
	}

	public void validandoSaldo(ContaBancaria buscaContaBancaria, @Valid SaqueRequestDto saqueDto) throws Exception {
		if (buscaContaBancaria.getId() == null) {
			throw new Exception("Erro, nao foi realizado o saque");

		}

		int retornValor = buscaContaBancaria.getSaldo().compareTo(saqueDto.getValor());
		if (retornValor == -1) {
			throw new Exception("Erro, nao foi possivel realizar o saque, não tem saldo suficiente R$:"
					+ buscaContaBancaria.getSaldo());
		}
	}

	public void salvandoExtrato(ContaBancaria buscaContaBancaria, @Valid SaqueRequestDto saqueDto) {
		extratoService.salvar(new Extrato(saqueDto.getValor(), saqueDto.getTitulo(), saqueDto.getDescricao(),
				Transacao.SAQUE, new ContaBancaria(buscaContaBancaria.getId())));
	}

	public ContaBancaria realizandoSaque(@Valid SaqueRequestDto saqueDto) throws Exception {

		ContaBancaria buscaContaBancaria = validaContaBancaria(saqueDto);
		validandoSaldo(buscaContaBancaria, saqueDto);

		salvandoExtrato(buscaContaBancaria, saqueDto);
		return efetuandoSaque(buscaContaBancaria, saqueDto);

	}

	public ContaBancaria efetuandoSaque(ContaBancaria buscaContaBancaria, @Valid SaqueRequestDto saqueDto) {
		buscaContaBancaria.setSaldo(buscaContaBancaria.getSaldo().subtract(saqueDto.getValor()));
		BeanUtils.copyProperties(saqueDto, buscaContaBancaria, "id");

		return contabancariaRepository.save(buscaContaBancaria);

	}

}
