package com.cadastrobancario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastrobancario.dto.DepositoRequestDto;
import com.cadastrobancario.dto.DepositoResponseDto;
import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.service.DepositoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class DepositoController {

	@Autowired
	private DepositoService depositoService;

	@ApiOperation(value = "Realizando deposito na conta bancaria")
	@PostMapping("/deposito")
	public ResponseEntity<DepositoResponseDto> realizandoDeposito(@Valid @RequestBody DepositoRequestDto depositoDto)
			throws Exception {

		ContaBancaria depositoSalva = depositoService.realizandoDeposito(depositoDto);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(DepositoResponseDto.converterDepositoParaResponseDto(depositoSalva));

	}

}
