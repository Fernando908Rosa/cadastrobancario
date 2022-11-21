package com.cadastrobancario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastrobancario.dto.TransacaoGenericoRequestDto;
import com.cadastrobancario.dto.TransacaoGenericoResponseDto;
import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.service.TransacaoGenericoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class TransacaoGenericoController {
	
	@Autowired
	TransacaoGenericoService transacaoGenericoService;
	
	@ApiOperation(value = "Realizando transacao generico na conta bancaria")
	@PostMapping("/transacaogenerico")
	public ResponseEntity<TransacaoGenericoResponseDto> realizandoTransacaoGenericoDto(
			@Valid @RequestBody TransacaoGenericoRequestDto transacaogenericoDto) throws Exception {

		ContaBancaria transacaogenericoSalvo = transacaoGenericoService
				.realizandoTransacaoGenerico(transacaogenericoDto);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(TransacaoGenericoResponseDto.converterTransacaoGenericoParaResponseDto(transacaogenericoSalvo));
	}

}
