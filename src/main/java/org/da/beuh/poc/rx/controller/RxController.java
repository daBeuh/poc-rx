package org.da.beuh.poc.rx.controller;

import org.da.beuh.poc.rx.model.Company;
import org.da.beuh.poc.rx.model.Person;
import org.da.beuh.poc.rx.service.CompanyService;
import org.da.beuh.poc.rx.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
@RestController
public class RxController {

	@Autowired
	private DeferredResultFactory factory;

	@Autowired
	private PersonService personService;

	@Autowired
	private CompanyService companyService;

	/**
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public DeferredResult<Person> createPerson(@RequestBody Person person) {
		return factory.create(personService.createPerson(person.getFirstName(), person.getLastName()));
	}

	/**
	 * @param company
	 * @return
	 */
	@RequestMapping(value = "/companies", method = RequestMethod.POST)
	public DeferredResult<Company> createCompany(@RequestBody Company company) {
		return factory.create(companyService.createCompany(company.getName(), company.getCountry()));
	}
}
