package br.com.santander.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.santander.api.documents.Gasto;
import br.com.santander.api.repositories.GastoRepository;
import br.com.santander.api.services.GastoService;

@Service
public class GastoServiceImpl implements GastoService {

	@Autowired
	private GastoRepository gastoRespository;

	@Override
	public Gasto findById(String id) {
		return this.gastoRespository.findOne(id);
	}

	@Override
	public Gasto atualizar(Gasto cliente) throws Exception {
		Gasto gasto = this.gastoRespository.findOne(cliente.getId());
		if (ObjectUtils.isEmpty(gasto.getCategorizacao())) {
			return this.gastoRespository.save(cliente);
		}
		throw new Exception("Gasto já Possui Categorização");
	}
}
