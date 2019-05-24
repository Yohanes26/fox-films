package br.com.fox.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fox.entity.DirectorEntity;
import br.com.fox.service.DirectorService;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class DirectorRestController {

	@Autowired
	private DirectorService directorService;

	@PostMapping(value = "/director")
	public ResponseEntity<?> saveDirector(
			@Valid @RequestBody DirectorEntity director) {
		
		return directorService.saveDirector(director);

	}

}
