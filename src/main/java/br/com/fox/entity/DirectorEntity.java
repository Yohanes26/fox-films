package br.com.fox.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document("directors")
public class DirectorEntity {

	@Id
	public String id;
	
	@NotEmpty
	public String name;
	
	@DateTimeFormat
	public Date birthdayDate;
	
	@NotEmpty
	public List<FilmEntity> films;
	
}
