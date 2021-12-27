package com.paigejones.driveLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paigejones.driveLicense.models.License;
import com.paigejones.driveLicense.models.Person;
import com.paigejones.driveLicense.services.LicenseService;
import com.paigejones.driveLicense.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/license/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPeople();
		model.addAttribute("persons", persons);
		return "createLicense.jsp";
	}
	
	@RequestMapping(value="/license/create", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "createLicense.jsp";
		}
		else {
			licenseService.create(license);
			model.addAttribute("license", license);
			model.addAttribute("person", license.getPerson());
			return "show.jsp";
		}
		
	}
	
}
