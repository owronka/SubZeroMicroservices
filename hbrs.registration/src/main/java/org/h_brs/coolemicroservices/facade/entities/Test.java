package org.h_brs.coolemicroservices.facade.entities;

import com.fasterxml.jackson.annotation.JsonView;

public class Test {

	private String name;
	private int alter;

	public String getName() {
		return name;
	}

	
	public int getAlter() {
		return alter;
	}


	@Override
	public String toString() {
		return this.name + this.alter;
	}
}
