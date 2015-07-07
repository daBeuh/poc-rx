package org.da.beuh.poc.rx.controller;

import org.da.beuh.poc.rx.model.Person;
import org.da.beuh.poc.rx.service.RxService;
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
	private RxService rxService;

	/**
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public DeferredResult<Person> createPerson(@RequestBody Person person) {
		return factory.create(rxService.createPerson(person.getFirstName(), person.getLastName()));
	}
}
