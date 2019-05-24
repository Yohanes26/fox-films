package br.com.fox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fox.entity.DirectorEntity;
import br.com.fox.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired
	private DirectorRepository directorRepository;
	
	@Override
	public ResponseEntity<?> saveDirector(DirectorEntity director) {
		
		try {
			directorRepository.save(director);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<DirectorEntity>(director, HttpStatus.CREATED);
	}


}
