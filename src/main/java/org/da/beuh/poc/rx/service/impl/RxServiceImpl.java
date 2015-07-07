/**
 *
 */
package org.da.beuh.poc.rx.service.impl;

import org.da.beuh.poc.rx.event.Event;
import org.da.beuh.poc.rx.model.Person;
import org.da.beuh.poc.rx.service.RxService;
import org.springframework.stereotype.Service;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
@Service
public class RxServiceImpl implements RxService {

	private PublishSubject<Event<Person>> personSubject = PublishSubject.create();

	/*
	 * (non-Javadoc)
	 *
	 * @see org.da.beuh.poc.rx.service.RxService#createPerson(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Observable<Person> createPerson(String firstName, String lastName) {
		return Observable.create(subscriber -> {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				subscriber.onError(e);
			}
			Person person = new Person(firstName, lastName);
			personSubject.onNext(new Event<>(person, "create"));
			subscriber.onNext(person);
			subscriber.onCompleted();
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.da.beuh.poc.rx.service.RxService#getPersonObservable()
	 */
	@Override
	public Observable<Event<Person>> getEventObservable() {
		return personSubject;
	}

}
