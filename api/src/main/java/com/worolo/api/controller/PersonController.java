package com.worolo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worolo.api.model.Person;
import com.worolo.api.service.PersonService;

@RestController
@RequestMapping("/api/user")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}
	
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Long id) {
		return personService.getPersonById(id);
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
		return personService.updatePerson(id, updatedPerson);
	}
	
	@DeleteMapping("/{id}")
	public boolean deletePerson(@PathVariable Long id) {
		return personService.deletePerson(id);
	}
}
