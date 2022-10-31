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

import com.cadastrobancario.dto.ContaBancariaRequestDto;
import com.cadastrobancario.dto.ContaBancariaResponseDto;
import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.service.ContaBancariaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ContaBancariaController {

	@Autowired
	private ContaBancariaService contabancariaService;

	@ApiOperation(value = "Listar", nickname = "listarTodos")
	@GetMapping("/contabancarias")
	public List<ContaBancariaResponseDto> getContaBancaria() {
		return contabancariaService.listarContaBancaria().stream()
				.map(contabancaria -> ContaBancariaResponseDto.converterContaBancariaParaResponseDto(contabancaria))
				.collect(Collectors.toList());

	}

	@ApiOperation(value = "Buscar Por Id", nickname = "buscarPorId")
	@GetMapping("/contabancaria/{id}")
	public ResponseEntity<ContaBancariaResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<ContaBancaria> contabancaria = contabancariaService.buscarPorId(id);
		return contabancaria.isPresent()
				? ResponseEntity.ok(ContaBancariaResponseDto.converterContaBancariaParaResponseDto(contabancaria.get()))
				: ResponseEntity.notFound().build();

	}

	@ApiOperation(value = "Salvar", nickname = "salvarContaBancaria")
	@PostMapping("/contabancaria/{idUsuario}")
	public ResponseEntity<ContaBancariaResponseDto> salvar(@PathVariable Long idUsuario,
			@Valid @RequestBody ContaBancariaRequestDto contabancariaDto) {
		ContaBancaria contantabancariaSalva = contabancariaService
				.salvar(contabancariaDto.converterContaBancariaRequestDtoParaEntidadeContaBancaria(idUsuario));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ContaBancariaResponseDto.converterContaBancariaParaResponseDto(contantabancariaSalva));

	}

	@ApiOperation(value = "Atualizar", nickname = "atualizarContaBancaria")
	@PutMapping("/contabancaria/{id}")
	public ResponseEntity<ContaBancariaResponseDto> atualizar(@PathVariable Long id, @PathVariable Long idUsuario,
			@Valid @RequestBody ContaBancariaRequestDto contabancariaDto) {
		ContaBancaria contabancariaAtualizada = contabancariaService.atualizar(id,
				contabancariaDto.converterContaBancariaRequestDtoParaEntidadeContaBancaria(idUsuario));
		return ResponseEntity
				.ok(ContaBancariaResponseDto.converterContaBancariaParaResponseDto(contabancariaAtualizada));
	}

	@ApiOperation(value = "Deletar", nickname = "deletarContaBancaria")
	@DeleteMapping("/contabancaria/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		contabancariaService.deletar(id);

	}

}
