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

import com.cadastrobancario.dto.SocioRequestDto;
import com.cadastrobancario.dto.SocioResponseDto;
import com.cadastrobancario.entity.Socio;
import com.cadastrobancario.service.SocioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class SocioController {

	@Autowired
	private SocioService socioService;

	@ApiOperation(value = "Listar todo socio")
	@GetMapping("/socio")

	public List<SocioResponseDto> getSocio() {
		return socioService.listarTodoSocio().stream()
				.map(socio -> SocioResponseDto.converterSocioParaResponseDto(socio)).collect(Collectors.toList());

	}

	@ApiOperation(value = "Buscar Socio Por Id")
	@GetMapping("/socio/{id}")
	public ResponseEntity<SocioResponseDto> buscarSocioPorId(@PathVariable Long id) {
		Optional<Socio> socio = socioService.buscarSocioPorId(id);
		return socio.isPresent() ? ResponseEntity.ok(SocioResponseDto.converterSocioParaResponseDto(socio.get()))
				: ResponseEntity.notFound().build();

	}

	@ApiOperation(value = "Salvar socio")
	@PostMapping("/socio")
	public ResponseEntity<SocioResponseDto> salvar(	@Valid @RequestBody SocioRequestDto socioDto) {
		Socio socioSalvo = socioService.salvar(socioDto.converterSocioRequestDtoParaEntidadeSocio());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SocioResponseDto.converterSocioParaResponseDto(socioSalvo));

	}

	@ApiOperation(value = "Atualizar Socio")
	@PutMapping("/socio/{id}")
	public ResponseEntity<SocioResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody SocioRequestDto socioDto) {
		Socio socioAtualizado = socioService.atualizar(id, socioDto.converterSocioRequestDtoParaEntidadeSocio());
		return ResponseEntity.ok(SocioResponseDto.converterSocioParaResponseDto(socioAtualizado));
	}

	@ApiOperation(value = "Deletar Socio")
	@DeleteMapping("/socio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		socioService.deletar(id);

	}

}
