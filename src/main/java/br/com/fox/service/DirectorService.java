package br.com.fox.service;

import org.springframework.http.ResponseEntity;

import br.com.fox.entity.DirectorEntity;

public interface DirectorService {

	public ResponseEntity<?> saveDirector(DirectorEntity director);
}
