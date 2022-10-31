package com.cadastrobancario.controller;

	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.cadastrobancario.dto.SaldoResponseDto;
	import com.cadastrobancario.entity.ContaBancaria;
	import com.cadastrobancario.service.SaldoService;

	import io.swagger.annotations.ApiOperation;

	@RestController
	@RequestMapping("/api")
	public class SaldoController {

		@Autowired
		private SaldoService saldoService;

		@ApiOperation(value = "Buscar Por Id")
		@GetMapping("/saldo/{id}")
		public ResponseEntity<SaldoResponseDto> buscarPorId(@PathVariable Long id) {
			Optional<ContaBancaria> contabancaria = saldoService.buscarPorId(id);
			return contabancaria.isPresent()
					? ResponseEntity.ok(SaldoResponseDto.converterSaldoParaResponseDto(contabancaria.get()))
					: ResponseEntity.notFound().build();
		
		}

	}

