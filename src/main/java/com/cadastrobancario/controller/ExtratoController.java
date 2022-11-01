package com.cadastrobancario.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cadastrobancario.dto.ExtratoRequestDto;
import com.cadastrobancario.dto.ExtratoResponseDto;
import com.cadastrobancario.entity.Extrato;
import com.cadastrobancario.service.ExtratoService;

import io.swagger.annotations.ApiOperation;

public class ExtratoController {

	@Autowired
	private ExtratoService extratoService;

	@ApiOperation(value = "Listar", nickname = "listarTodos")
	@GetMapping("/extratos")
	public List<ExtratoResponseDto> getExtrato() {
		return extratoService.LitarExtrato().stream()
				.map(extrato -> ExtratoResponseDto.converterExtratoParaExtratoResponseDto(extrato))
				.collect(Collectors.toList());

	}

	@ApiOperation(value = "Buscar Por Extrato", nickname = "buscarPorExtrato")
	@GetMapping("/contabancaria/{id}")
	public ResponseEntity<ExtratoResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<Extrato> extrato = extratoService.buscarPorId(id);
		return extrato.isPresent()
				? ResponseEntity.ok(ExtratoResponseDto.converterExtratoParaExtratoResponseDto(extrato.get()))
				: ResponseEntity.notFound().build();

	}

	@ApiOperation(value = "Salvar", nickname = "salvarExtrato")
	@PostMapping("/extrato/{idContaBancaria}")
	public ResponseEntity<ExtratoResponseDto> salvar(@PathVariable Long idContaBancaria,
			@Valid @RequestBody ExtratoRequestDto extratoDto) {
		Extrato extratoSalva = extratoService
				.salvar(extratoDto.converterExtratoRequestDtoParaEntidadeExtrato(idContaBancaria));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ExtratoResponseDto.converterExtratoParaExtratoResponseDto(extratoSalva));

	}

	@ApiOperation(value = "Atualizar", nickname = "atualizarExtrato")
	@PutMapping("/extrato/{id}")
	public ResponseEntity<ExtratoResponseDto> atualizar(@PathVariable Long id, @PathVariable Long idContaBancaria,
			@Valid @RequestBody ExtratoRequestDto extratoDto) {
		Extrato ExtratoAtualizado = extratoService.atualizar(id,
				extratoDto.converterExtratoRequestDtoParaEntidadeExtrato(idContaBancaria));
		return ResponseEntity.ok(ExtratoResponseDto.converterExtratoParaExtratoResponseDto(ExtratoAtualizado));
	}

	@ApiOperation(value = "Deletar", nickname = "deletarExtrato")
	@DeleteMapping("/extrato/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		extratoService.deletar(id);

	}

}
