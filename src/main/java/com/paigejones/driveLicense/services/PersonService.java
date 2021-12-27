package com.paigejones.driveLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paigejones.driveLicense.models.Person;
import com.paigejones.driveLicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPeople(){
		return personRepository.findAll();
	}
	
	public Person create(Person person) {
		personRepository.save(person);
		return person;
	}
	
	public Person findPerson(Long id) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			return person.get();
		}
		else {
			return null;
		}
	}
	
	public Long deletePerson(Long id) {
		 personRepository.deleteById(id);
		 return id;
	}
}
