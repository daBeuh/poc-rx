/**
 *
 */
package org.da.beuh.poc.rx.event.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.da.beuh.poc.rx.event.Event;
import org.da.beuh.poc.rx.event.RxEventAggregator;
import org.da.beuh.poc.rx.event.RxEventEmitter;
import org.da.beuh.poc.rx.model.EntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * @author Da Beuh
 * @date 12 juil. 2015
 */
@Component
public class RxEventAggregatorImpl implements RxEventAggregator {

	@Autowired
	private List<RxEventEmitter<? extends EntityModel>> eventEmitters;

	private PublishSubject<Event<? extends EntityModel>> subject = PublishSubject.create();

	/**
	 *
	 */
	@PostConstruct
	private void init() {
		eventEmitters.stream()
				.map(RxEventEmitter::getEventObservable)
				.reduce(Observable.<Event<? extends EntityModel>> empty(),
						Observable::merge,
						Observable::merge)
				.observeOn(Schedulers.computation())
				.subscribeOn(Schedulers.computation())
				.subscribe(subject);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.da.beuh.poc.rx.event.RxEventAggregator#getEventObservable()
	 */
	@Override
	public Observable<Event<? extends EntityModel>> getEventObservable() {
		return subject.asObservable();
	}

}
