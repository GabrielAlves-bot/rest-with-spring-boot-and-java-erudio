package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
		
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE )
	public Person findById(@PathVariable(value = "id") String id) throws Exception{
		return service.findById(id);		
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE )
	public List <Person> findAll(){
		return service.findAll();		
	}
	
	@RequestMapping(method = RequestMethod.POST,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE )
	public Person createPerson(@RequestBody Person person){
		return service.create(person);		
	}
	
	@RequestMapping(method = RequestMethod.PUT,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE )
	public Person update(@RequestBody Person person){
		return service.update(person);		
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) throws Exception{
		service.delete(id);		
	}
	
}
