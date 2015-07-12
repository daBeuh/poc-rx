package org.da.beuh.poc.rx.event;

/**
 * @author Da Beuh
 * @date 7 juil. 2015
 */
public class Event<T> {

	private T subject;

	private String type;

	/**
	 * @param subject
	 * @param type
	 */
	public Event(T subject, String type) {
		this.subject = subject;
		this.type = type;
	}

	/**
	 * @return the subject
	 */
	public T getSubject() {
		return subject;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [subject=" + subject + ", type=" + type + "]";
	}

}
