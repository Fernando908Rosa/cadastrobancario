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

import com.cadastrobancario.dto.ContatoRequestDto;
import com.cadastrobancario.dto.ContatoResponseDto;
import com.cadastrobancario.entity.Contato;
import com.cadastrobancario.service.ContatoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@ApiOperation(value = "Listar todo Contato")
	@GetMapping("contato")
	public List<ContatoResponseDto> getContato() {
		return contatoService.listarTodoContato().stream()
				.map(contato -> ContatoResponseDto.converterContatoParaResponseDto(contato))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar Contato Por Id")
	@GetMapping("/contato/{id}")
	public ResponseEntity<ContatoResponseDto> buscarContatoPorId(@PathVariable Long id) {
		Optional<Contato> contato = contatoService.buscarContatoPorId(id);
		return contato.isPresent()
				? ResponseEntity.ok(ContatoResponseDto.converterContatoParaResponseDto(contato.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar Contato")
	@PostMapping("/contato")
	public ResponseEntity<ContatoResponseDto> salvarContato(@Valid @RequestBody ContatoRequestDto contatoDto) {
		Contato contatoSalvo = contatoService.salvar(contatoDto.converterContatoRequestDtoParaEntidadeContato());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ContatoResponseDto.converterContatoParaResponseDto(contatoSalvo));
	}

	@ApiOperation(value = "Atualizar Contato")
	@PutMapping("/contato/{id}")
	public ResponseEntity<ContatoResponseDto> atualizarContato(@PathVariable Long id,
			@Valid @RequestBody ContatoRequestDto contatoDto) {
		Contato contatoAtualizado = contatoService.atualizar(id,
				contatoDto.converterContatoRequestDtoParaEntidadeContato());
		return ResponseEntity.ok(ContatoResponseDto.converterContatoParaResponseDto(contatoAtualizado));

	}

	@ApiOperation(value = "Deletar contato")
	@DeleteMapping("/contato/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		contatoService.deletar(id);
	}

}
