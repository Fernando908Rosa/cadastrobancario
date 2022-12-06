package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.Socio;
import com.cadastrobancario.repository.SocioRepository;

@Service
public class SocioService {

	@Autowired
	private SocioRepository socioRepository;

	public List<Socio> listarTodoSocio() {
		return socioRepository.findAll();

	}

	public Optional<Socio> buscarSocioPorId(Long id) {
		return socioRepository.findById(id);
	}

	public Socio salvar(Socio socio) {
		return socioRepository.save(socio);

	}

	public Socio atualizar(Long Id, Socio socioSalvo) {
		Socio socioVaiSerAtualizado = validarSocioExistente(Id);
		BeanUtils.copyProperties(socioSalvo, socioVaiSerAtualizado, "id");
		return socioRepository.save(socioVaiSerAtualizado);
	}

	public void deletar(Long id) {
		socioRepository.deleteById(id);
	}

	private Socio validarSocioExistente(Long id) {
		Optional<Socio> socio = buscarSocioPorId(id);
		if (socio.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return socio.get();
	}

}
