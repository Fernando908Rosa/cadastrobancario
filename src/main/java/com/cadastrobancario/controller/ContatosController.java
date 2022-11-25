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

import com.cadastrobancario.dto.ContatosRequestDto;
import com.cadastrobancario.dto.ContatosResponseDto;
import com.cadastrobancario.entity.Contatos;
import com.cadastrobancario.service.ContatosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ContatosController {

	@Autowired
	private ContatosService contatosService;

	@ApiOperation(value = "Listar todos Contatos")
	@GetMapping("contatos")
	public List<ContatosResponseDto> getContatos() {
		return contatosService.listarTodosContatos().stream()
				.map(contatos -> ContatosResponseDto.converterContatosParaResponseDto(contatos))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar Contatos Por Id")
	@GetMapping("/contatos/{id}")
	public ResponseEntity<ContatosResponseDto> buscarContatosPorId(@PathVariable Long id) {
		Optional<Contatos> contatos = contatosService.buscarContatosPorId(id);
		return contatos.isPresent()
				? ResponseEntity.ok(ContatosResponseDto.converterContatosParaResponseDto(contatos.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar Contatos")
	@PostMapping("/contatos")
	public ResponseEntity<ContatosResponseDto> salvar(@Valid @RequestBody ContatosRequestDto contatosDto) {
		Contatos contatosSalvos = contatosService.salvar(contatosDto.converterContatosRequestDtoParaEntidadeContatos());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ContatosResponseDto.converterContatosParaResponseDto(contatosSalvos));
	}

	@ApiOperation(value = "Atualizar Contatos")
	@PutMapping("/contatos/{id}")
	public ResponseEntity<ContatosResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody ContatosRequestDto contatosDto) {
		Contatos contatosAtualizados = contatosService.atualizar(id,
				contatosDto.converterContatosRequestDtoParaEntidadeContatos());
		return ResponseEntity.ok(ContatosResponseDto.converterContatosParaResponseDto(contatosAtualizados));

	}

	@ApiOperation(value = "Deletar contatos")
	@DeleteMapping("/contatos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		contatosService.deletar(id);
	}

}
