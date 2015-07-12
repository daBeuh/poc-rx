package org.da.beuh.poc.rx.service;

import org.da.beuh.poc.rx.event.Event;
import org.da.beuh.poc.rx.event.RxEventEmitter;
import org.da.beuh.poc.rx.model.Person;

import rx.Observable;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
public interface PersonService extends RxEventEmitter<Person> {

	/**
	 * Create a {@link Person} from given {@code firstName} and {@code lastName}
	 *
	 * @param firstName
	 * @param lastName
	 * @return {@link Observable}
	 */
	Observable<Person> createPerson(final String firstName, final String lastName);

	/**
	 * @return
	 */
	@Override
	Observable<Event<Person>> getEventObservable();

}
