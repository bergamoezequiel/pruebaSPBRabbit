package com.example.prueba;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GeoConsult {
	
	@Autowired
	private RabbitTemplate rabbittemplate;

	@Autowired
	private GeoConsultRepository geoConsultRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/pais/{name}")
	public GeoConsultResponse saludarBeanPath(@PathVariable String name ) {
		PaisCache pais = new PaisCache();pais.setPais(name);pais.setNumero("1");
		geoConsultRepository.save(pais);
		
		
		GeoConsultResponse response= new GeoConsultResponse();
		response.setPais(name);
		response.setDescription("randomDescription");
		
		return response;
	} 
	
	@RequestMapping(method = RequestMethod.GET, path = "/paises")
	public List<PaisCache> saludarBeanPath() {
		
		memoria.lista+=1;
		return geoConsultRepository.findAll();
	} 
	
	@RequestMapping(method = RequestMethod.GET, path = "/memoria")
	public int saludarBeanPath2() {
		
		
		return memoria.lista;
	} 
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/info/{name}", produces = "application/json")
	public ResponseEntity<Object> prueba(@PathVariable String name ) {
		final String baseUri = "https://restcountries.eu/rest/v2/alpha/";
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> resp;

		resp= restTemplate.getForEntity(baseUri + name, String.class);
		
	
		return new ResponseEntity(resp.getBody(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/enqueue/{name}", produces = "application/json")
	public String prueba2(@PathVariable String name ) {
		GeoConsultResponse geo= new GeoConsultResponse(); geo.setDescription("desc");geo.setPais("EZE");
		rabbittemplate.convertAndSend("myQueue", geo.toString());
	return "ok";
	}

} 
