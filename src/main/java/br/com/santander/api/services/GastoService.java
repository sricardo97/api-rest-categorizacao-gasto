package br.com.santander.api.services;

import br.com.santander.api.documents.Gasto;

public interface GastoService {

	Gasto findById(String id);

	Gasto atualizar(Gasto gasto) throws Exception;
}