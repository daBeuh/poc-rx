package org.da.beuh.poc.rx.event;

import org.da.beuh.poc.rx.model.EntityModel;

import rx.Observable;

/**
 * @author Da Beuh
 * @date 12 juil. 2015
 */
public interface RxEventAggregator {

	/**
	 * @return
	 */
	Observable<Event<? extends EntityModel>> getEventObservable();

}
