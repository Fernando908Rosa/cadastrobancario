package com.cadastrobancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrobancario.entity.Empresa;
import com.cadastrobancario.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Empresa> listarTodasEmpresa() {
		return empresaRepository.findAll();

	}

	public Optional<Empresa> buscarEmpresaPorId(Long id) {
		return empresaRepository.findById(id);
	}

	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);

	}

	public Empresa atualizar(Long Id, Empresa empresaSalvar) {
		Empresa empresaVaiSerAtualizada = validarEmpresaExistente(Id);
		BeanUtils.copyProperties(empresaSalvar, empresaVaiSerAtualizada, "id");
		return empresaRepository.save(empresaVaiSerAtualizada);
	}

	public void deletar(Long id) {
		empresaRepository.deleteById(id);
	}

	private Empresa validarEmpresaExistente(Long id) {
		Optional<Empresa> empresa = buscarEmpresaPorId(id);
		if (empresa.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return empresa.get();
	}

}
