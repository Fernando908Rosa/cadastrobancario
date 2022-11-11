package com.cadastrobancario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastrobancario.dto.SaqueRequestDto;
import com.cadastrobancario.dto.SaqueResponseDto;
import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.service.SaqueService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class SaqueController {

	@Autowired
	private SaqueService saqueService;

	@ApiOperation(value = "Realizando Saque na conta bancaria")
	@PostMapping("/saque")
	public ResponseEntity<SaqueResponseDto> realizarSaque(@Valid @RequestBody SaqueRequestDto saqueDto)
			throws Exception {

		ContaBancaria saqueSalvo = saqueService.realizandoSaque(saqueDto);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SaqueResponseDto.converterSaqueParaResponseDto(saqueSalvo));

	}

}
