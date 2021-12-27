package com.paigejones.driveLicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paigejones.driveLicense.models.Person;
import com.paigejones.driveLicense.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "createPerson.jsp";
	}
	
	@RequestMapping(value="/person/create", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "createPerson.jsp";
		}
		else {
			personService.create(person);
			return "redirect:/license/new";
		}
		
	}

}
