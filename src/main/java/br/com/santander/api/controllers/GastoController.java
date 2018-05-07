package br.com.santander.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.api.documents.Categorizacao;
import br.com.santander.api.documents.Gasto;
import br.com.santander.api.responses.Response;
import br.com.santander.api.services.GastoService;

@RestController
@RequestMapping(path = "/api/gastos")
public class GastoController {

	@Autowired
	private GastoService gastoService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Gasto>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Gasto>(this.gastoService.findById(id)));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<?>> atualizar(@PathVariable(name = "id") String id,
			@Valid @RequestBody Categorizacao categorizacao, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Gasto>(erros));
		}
		Gasto gasto = new Gasto();
		gasto.setId(id);
		gasto.setCategorizacao(categorizacao);
		try {
			return ResponseEntity.ok(new Response<Gasto>(this.gastoService.atualizar(gasto)));
		} catch (Exception e) {
			return ResponseEntity.ok(new Response<String>(e.getMessage().toString()));
		}
	}
}