package com.worolo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.Person;
import com.worolo.api.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	public Person getPersonById(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person updatePerson(Long id, Person updatedPerson) {
		Person existingPerson = personRepository.findById(id).orElse(null);
        if (existingPerson != null) {
        	existingPerson.setEmail(updatedPerson.getEmail());
        	existingPerson.setPassword(updatedPerson.getPassword());
        	existingPerson.setPhoneNumber(updatedPerson.getPhoneNumber());
        	existingPerson.setAddress(updatedPerson.getAddress());
            
            return personRepository.save(existingPerson);
        }
        return null;
	}
	
	public boolean deletePerson(Long id) {
		Person existingPerson = personRepository.findById(id).orElse(null);
        if (existingPerson != null) {
            personRepository.delete(existingPerson);
            return true;
        }
        return false;
	}
}
