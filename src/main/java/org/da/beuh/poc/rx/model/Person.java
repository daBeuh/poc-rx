/**
 *
 */
package org.da.beuh.poc.rx.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
public class Person {

	private String firstName;

	private String lastName;

	private Calendar creationDate;

	/**
	 * @param firstName
	 * @param lastName
	 * @param creationDate
	 */
	@JsonCreator
	public Person(@JsonProperty("firstName") final String firstName, @JsonProperty("lastName") final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDate = Calendar.getInstance();
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the creationDate
	 */
	public Calendar getCreationDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(creationDate.getTime());
		return cal;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", creationDate=" + creationDate.getTimeInMillis() + "]";
	}

}
