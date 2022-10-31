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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@ApiOperation(value = "Listar", nickname = "listarTodos")
	@GetMapping("/depositos")
	public List<DepositoResponseDto> getContaBancaria() {
		return depositoService.listarContaBancaria().stream()
				.map(contabancaria -> DepositoResponseDto.converterDepositoParaResponseDto(contabancaria))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar Por Id", nickname = "buscarPorId")
	@GetMapping("/deposito/{id}")
	public ResponseEntity<DepositoResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<ContaBancaria> contabancaria = depositoService.buscarPorId(id);
		return contabancaria.isPresent()
				? ResponseEntity.ok(DepositoResponseDto.converterDepositoParaResponseDto(contabancaria.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar", nickname = "salvarDeposito")
	@PostMapping("/deposito")
	public ResponseEntity<DepositoResponseDto> salvar(@Valid @RequestBody DepositoRequestDto depositoDto)
			throws Exception {
		ContaBancaria depositoSalva = depositoService
				.salvar(depositoDto.converterDepositoRequestDtoParaEntidadeContaBancaria());

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(DepositoResponseDto.converterDepositoParaResponseDto(depositoSalva));

	}

	@ApiOperation(value = "Atualizar", nickname = "atualizarDeposito")
	@PutMapping("/deposito/{id}")
	public ResponseEntity<DepositoResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody DepositoRequestDto depositoDto) {
		ContaBancaria depositoAtualizado = depositoService.atualizar(id,
				depositoDto.converterDepositoRequestDtoParaEntidadeContaBancaria());
		return ResponseEntity.ok(DepositoResponseDto.converterDepositoParaResponseDto(depositoAtualizado));

	}

	@ApiOperation(value = "Deletar", nickname = "deletarDeposito")
	@DeleteMapping("/deposito/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		depositoService.deletar(id);
	}

}
