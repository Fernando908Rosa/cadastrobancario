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

import com.cadastrobancario.dto.EmpresaRequestDto;
import com.cadastrobancario.dto.EmpresaResponseDto;
import com.cadastrobancario.entity.Empresa;
import com.cadastrobancario.service.EmpresaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@ApiOperation(value = "Listar")
	@GetMapping("/empresas")
	public List<EmpresaResponseDto> getEmpresa() {
		return empresaService.listarTodasEmpresa().stream()
				.map(empresa -> EmpresaResponseDto.converterEmpresaParaResponseDto(empresa))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar Por Id Empresa")
	@GetMapping("/empresa/{id}")
	public ResponseEntity<EmpresaResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<Empresa> empresa = empresaService.buscarEmpresaPorId(id);
		return empresa.isPresent()
				? ResponseEntity.ok(EmpresaResponseDto.converterEmpresaParaResponseDto(empresa.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar Empresa")
	@PostMapping("/empresa")
	public ResponseEntity<EmpresaResponseDto> salvar(@Valid @RequestBody EmpresaRequestDto empresaDto) {
		Empresa empresaSalva = empresaService.salvar(empresaDto.converterEmpresaRequestDtoParaEntidadeEmpresa());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(EmpresaResponseDto.converterEmpresaParaResponseDto(empresaSalva));
	}

	@ApiOperation(value = "Atualizar Empresa")
	@PutMapping("/empresa/{id}")
	public ResponseEntity<EmpresaResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody EmpresaRequestDto empresaDto) {
		Empresa empresaAtualizada = empresaService.atualizar(id,
				empresaDto.converterEmpresaRequestDtoParaEntidadeEmpresa());
		return ResponseEntity.ok(EmpresaResponseDto.converterEmpresaParaResponseDto(empresaAtualizada));

	}

	@ApiOperation(value = "Deletar Empresa")
	@DeleteMapping("/empresa/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		empresaService.deletar(id);
	}

}
