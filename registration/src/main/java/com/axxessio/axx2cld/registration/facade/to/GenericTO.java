package com.axxessio.axx2cld.registration.facade.to;

//import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericTO { //extends ResourceSupport{
	ObjectMapper mapper = new ObjectMapper();
	
	public String toJSON () throws JsonProcessingException {
		return mapper.writeValueAsString(this);
	}
}
