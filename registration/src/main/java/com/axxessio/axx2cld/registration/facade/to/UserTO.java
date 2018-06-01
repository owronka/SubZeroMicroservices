package com.axxessio.axx2cld.registration.facade.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserTO extends GenericTO {
	private long version;
	
	PersonTO [] ptos;
	
	@JsonCreator
	public UserTO (@JsonProperty("version") long version, @JsonProperty("ptos") PersonTO [] ptos) {
		this.version = version;
		this.ptos = ptos;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public PersonTO[] getPtos() {
		return ptos;
	}

	public void setPtos(PersonTO[] ptos) {
		this.ptos = ptos;
	}
}
