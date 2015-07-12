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
public class Company implements EntityModel {

	private String name;

	private String country;

	private Calendar creationDate;

	/**
	 * @param firstName
	 * @param lastName
	 * @param creationDate
	 */
	@JsonCreator
	public Company(@JsonProperty("name") final String name, @JsonProperty("country") final String country) {
		this.name = name;
		this.country = country;
		this.creationDate = Calendar.getInstance();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
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
		return "Company [name=" + name + ", country=" + country + ", creationDate=" + creationDate.getTimeInMillis() + "]";
	}

}
