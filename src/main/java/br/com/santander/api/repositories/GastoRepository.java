package br.com.santander.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.santander.api.documents.Gasto;

public interface GastoRepository extends MongoRepository<Gasto, String> {

}
