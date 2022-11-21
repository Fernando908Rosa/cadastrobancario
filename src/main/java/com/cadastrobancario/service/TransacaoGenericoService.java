package com.cadastrobancario.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastrobancario.dto.TransacaoGenericoRequestDto;
import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.entity.Extrato;
import com.cadastrobancario.enuns.Transacao;
import com.cadastrobancario.repository.ContaBancariaRepository;

@Service
public class TransacaoGenericoService {

	@Autowired
	private ContaBancariaRepository contaBancariaRepository;

	@Autowired
	private ExtratoService extratoService;

	public ContaBancaria retornandoContaBancaria(TransacaoGenericoRequestDto transacaogenericoDto) {
		return contaBancariaRepository.findByAgenciaAndNumerodaconta(transacaogenericoDto.getAgencia(),
				transacaogenericoDto.getNumerodaconta());

	}

	public void validandocontaBancaria(ContaBancaria buscarContaBancaria) throws Exception {
		if (buscarContaBancaria.getId() == null) {
			throw new Exception("nao foi possivel fazer transacao generico");
		}
	}

	public void salvandoExtrato(ContaBancaria buscarContaBancaria,
			@Valid TransacaoGenericoRequestDto transacaogenericoDto) {
		extratoService.salvar(new Extrato(transacaogenericoDto.getSaldo(), transacaogenericoDto.getTitulo(),
				transacaogenericoDto.getDescricao(), transacaogenericoDto.getTransacaogenerico(),
				new ContaBancaria(buscarContaBancaria.getId())));
	}

	public ContaBancaria realizandoTransacaoGenerico(@Valid TransacaoGenericoRequestDto transacaogenericoDto)
			throws Exception {
		
		
		

		ContaBancaria buscarContaBancaria = retornandoContaBancaria(transacaogenericoDto);
		validandocontaBancaria(buscarContaBancaria);
		salvandoExtrato(buscarContaBancaria, transacaogenericoDto);
		return efetuadoTransacaoGenerico(buscarContaBancaria, transacaogenericoDto);
	}

	public void validandoSaldo(ContaBancaria buscaContaBancaria,
			@Valid TransacaoGenericoRequestDto transacaoGenericoRequestDto) throws Exception {
		if (buscaContaBancaria.getId() == null) {
			throw new Exception("Erro, nao foi realizar  o saque");

		}

		if (buscaContaBancaria.getSaldo().compareTo(transacaoGenericoRequestDto.getSaldo()) == -1) {
			throw new Exception("Erro, nao foi possivel realizar o saque, não tem saldo suficiente R$:"
					+ buscaContaBancaria.getSaldo());
		}
	}

	private ContaBancaria efetuadoTransacaoGenerico(ContaBancaria buscarContaBancaria,
			@Valid TransacaoGenericoRequestDto transacaogenericoDto) throws Exception {

		if (transacaogenericoDto.getTransacaogenerico() == Transacao.DEPOSITO
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.TED_ENTRADA
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.PIX_ENTRADA
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.DOC_ENTRADA) {

			transacaogenericoDto.setSaldo(buscarContaBancaria.getSaldo().add(transacaogenericoDto.getSaldo()));
		}

		if (transacaogenericoDto.getTransacaogenerico() == Transacao.CREDITO
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.DEBITO
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.DOC_SAIDA
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.PIX_SAIDA
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.TED_SAIDA
				|| transacaogenericoDto.getTransacaogenerico() == Transacao.SAQUE) {

			validandoSaldo(buscarContaBancaria, transacaogenericoDto);

			transacaogenericoDto.setSaldo(buscarContaBancaria.getSaldo().subtract(transacaogenericoDto.getSaldo()));
		}
		BeanUtils.copyProperties(transacaogenericoDto, buscarContaBancaria, "id");

		return contaBancariaRepository.save(buscarContaBancaria);

	}
}
