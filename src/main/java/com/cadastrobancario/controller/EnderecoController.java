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

import com.cadastrobancario.dto.EnderecoRequestDto;
import com.cadastrobancario.dto.EnderecoResponseDto;
import com.cadastrobancario.entity.Endereco;
import com.cadastrobancario.service.EnderecoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@ApiOperation(value = "Listar todos Endereco")
	@GetMapping("/enderecos")
	public List<EnderecoResponseDto> getEnderecos() {
		return enderecoService.listarTodosEnderecos().stream()
				.map(endereco -> EnderecoResponseDto.converterEnderecoParaResponseDto(endereco))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar Endereco Por Id")
	@GetMapping("/endereco/{id}")
	public ResponseEntity<EnderecoResponseDto> buscarEnderecoPorId(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoService.buscarEnderecoPorId(id);
		return endereco.isPresent()
				? ResponseEntity.ok(EnderecoResponseDto.converterEnderecoParaResponseDto(endereco.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar Endereco")
	@PostMapping("/endereco")
	public ResponseEntity<EnderecoResponseDto> salvar(@Valid @RequestBody EnderecoRequestDto enderecoDto) {
		Endereco enderecoSalvo = enderecoService.salvar(enderecoDto.converterEnderecoRequestDtoParaEntidadeEndereco());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(EnderecoResponseDto.converterEnderecoParaResponseDto(enderecoSalvo));
	}

	@ApiOperation(value = "Atualizar Endereco")
	@PutMapping("/endereco/{id}")
	public ResponseEntity<EnderecoResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody EnderecoRequestDto enderecoDto) {
		Endereco enderecoAtualizado = enderecoService.atualizar(id,
				enderecoDto.converterEnderecoRequestDtoParaEntidadeEndereco());
		return ResponseEntity.ok(EnderecoResponseDto.converterEnderecoParaResponseDto(enderecoAtualizado));

	}

	@ApiOperation(value = "Deletar Endereco")
	@DeleteMapping("/endereco/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		enderecoService.deletar(id);
	}

}
