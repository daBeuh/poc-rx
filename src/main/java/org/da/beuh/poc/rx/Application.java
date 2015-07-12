package org.da.beuh.poc.rx;

import javax.annotation.PostConstruct;

import org.da.beuh.poc.rx.event.RxEventAggregator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
@SpringBootApplication
public class Application {

	/**
	 * Application's logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	/**
	 *
	 */
	@Autowired
	private RxEventAggregator eventAggregator;

	/**
	 *
	 */
	@PostConstruct
	private void init() {
		eventAggregator.getEventObservable()
				.subscribe(event -> {
					LOGGER.info("New event: {}", event);
				});
	}

	// ****************************************************************

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
