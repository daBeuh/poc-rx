/**
 *
 */
package org.da.beuh.poc.rx.service.impl;

import org.da.beuh.poc.rx.event.Event;
import org.da.beuh.poc.rx.model.Company;
import org.da.beuh.poc.rx.service.CompanyService;
import org.springframework.stereotype.Service;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	private PublishSubject<Event<Company>> companySubject = PublishSubject.create();

	/*
	 * (non-Javadoc)
	 *
	 * @see org.da.beuh.poc.rx.service.RxService#createPerson(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Observable<Company> createCompany(String name, String country) {
		return Observable.create(subscriber -> {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				subscriber.onError(e);
			}
			Company company = new Company(name, country);
			companySubject.onNext(new Event<>(company, "create"));
			subscriber.onNext(company);
			subscriber.onCompleted();
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.da.beuh.poc.rx.service.RxService#getPersonObservable()
	 */
	@Override
	public Observable<Event<Company>> getEventObservable() {
		return companySubject;
	}

}
