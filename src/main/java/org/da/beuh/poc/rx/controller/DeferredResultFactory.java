package org.da.beuh.poc.rx.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import rx.Observable;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
@Component
public class DeferredResultFactory {

	/**
	 * @param observable
	 * @return
	 */
	public <T> DeferredResult<T> create(Observable<T> observable) {
		DeferredResult<T> deferred = new DeferredResult<>();
		observable.subscribe(deferred::setResult, deferred::setErrorResult);
		return deferred;
	}

}
