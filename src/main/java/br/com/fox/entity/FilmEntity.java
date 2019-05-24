package br.com.fox.entity;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("films")
public class FilmEntity {
		
	@NotEmpty
	public String name;
	
	@NotEmpty
	public String year;
}
