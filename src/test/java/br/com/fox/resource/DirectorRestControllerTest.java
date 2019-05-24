package br.com.fox.resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.fox.ApplicationTests;
import br.com.fox.entity.DirectorEntity;
import br.com.fox.entity.FilmEntity;
import br.com.fox.model.DirectorModel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ComponentScan("br.com.fox")
public class DirectorRestControllerTest extends ApplicationTests {
		
	private MockMvc mockMvc;
	
	@Autowired
	private DirectorRestController controller;
	
	@Autowired
	Gson gson;

	public final String REST_SERVICE_URI = "http://localhost:8090/api/v1";

	private DirectorModel director;
	
	private List<FilmEntity> films;
	
	private FilmEntity film;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	/**
	 * Testa se a conexao esta funcionando
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1_GetIndexRestController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post(REST_SERVICE_URI + "/director/"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void test2_saveDirector() throws Exception {

		director = new DirectorModel();
		director.name = "Kevin Feige";
		director.birthdayDate = "1900-10-10";
		
		films = new ArrayList<FilmEntity>();
		
		film = new FilmEntity();
		film.name = "Os vingadores";
		film.year = "2019";
		films.add(film);
		
		film = new FilmEntity();
		film.name = "Guardiões da Galaxia";
		film.year = "2018";
		films.add(film);
		
		director.films = films;
			
		String json = gson.toJson(director, DirectorModel.class);
			
		System.out.println(json);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(REST_SERVICE_URI + "/director/")
						.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isCreated());

	}

}
