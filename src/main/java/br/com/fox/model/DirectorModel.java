package br.com.fox.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fox.entity.FilmEntity;

public class DirectorModel {
	
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("birthdayDate")
	public String birthdayDate;
	
	@JsonProperty("films")
	public List<FilmEntity> films;
	
}
