package br.com.fox.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fox.entity.DirectorEntity;

public interface DirectorRepository extends MongoRepository<DirectorEntity, String>{

}
