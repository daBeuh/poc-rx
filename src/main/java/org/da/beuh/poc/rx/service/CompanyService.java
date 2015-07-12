package org.da.beuh.poc.rx.service;

import org.da.beuh.poc.rx.event.Event;
import org.da.beuh.poc.rx.event.RxEventEmitter;
import org.da.beuh.poc.rx.model.Company;

import rx.Observable;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
public interface CompanyService extends RxEventEmitter<Company> {

	/**
	 * Create a {@link Company} from given {@code name} and {@code country}
	 *
	 * @param firstName
	 * @param lastName
	 * @return {@link Observable}
	 */
	Observable<Company> createCompany(final String name, final String country);

	/**
	 * @return
	 */
	@Override
	Observable<Event<Company>> getEventObservable();

}
