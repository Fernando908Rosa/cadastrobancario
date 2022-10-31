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

import com.cadastrobancario.dto.UsuarioRequestDto;
import com.cadastrobancario.dto.UsuarioResponseDto;
import com.cadastrobancario.entity.Usuario;
import com.cadastrobancario.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation(value = "Listar", nickname = "listarTodos")
	@GetMapping("/usuarios")
	public List<UsuarioResponseDto> getUsuario() {
		return usuarioService.listarUsuario().stream()
				.map(usuario -> UsuarioResponseDto.converterUsuarioParaUsuarioResponseDto(usuario))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar Por Id", nickname = "buscarPorId")
	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.buscarPorId(id);
		return usuario.isPresent()
				? ResponseEntity.ok(UsuarioResponseDto.converterUsuarioParaUsuarioResponseDto(usuario.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar", nickname = "salvarUsuario")
	@PostMapping("/usuario")
	public ResponseEntity<UsuarioResponseDto> salvar(@Valid @RequestBody UsuarioRequestDto usuarioDto) {
		Usuario usuarioSalva = usuarioService.salvar(usuarioDto.converterUsuarioRequestDtoParaEntidadeUsuario());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(UsuarioResponseDto.converterUsuarioParaUsuarioResponseDto(usuarioSalva));
	}

	@ApiOperation(value = "Atualizar", nickname = "atualizarUsuario")
	@PutMapping("/usuario/{id}")
	public ResponseEntity<UsuarioResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody UsuarioRequestDto usuarioDto) {
		Usuario usuarioAtualizado = usuarioService.atualizar(id,
				usuarioDto.converterUsuarioRequestDtoParaEntidadeUsuario());
		return ResponseEntity.ok(UsuarioResponseDto.converterUsuarioParaUsuarioResponseDto(usuarioAtualizado));

	}

	@ApiOperation(value = "Deletar", nickname = "deletarUsuario")
	@DeleteMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		usuarioService.deletar(id);
	}

}
