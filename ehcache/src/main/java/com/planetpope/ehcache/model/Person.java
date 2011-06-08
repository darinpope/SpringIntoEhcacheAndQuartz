package com.planetpope.ehcache.model;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String personId;
	private String firstName;
	private String lastName;

	public final String getPersonId() {
		return personId;
	}

	public final void setPersonId(String personId) {
		this.personId = personId;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public final String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

	
}
