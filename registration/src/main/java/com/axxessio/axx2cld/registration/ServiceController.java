package com.axxessio.axx2cld.registration;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/service")
	public Service service(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Service(counter.incrementAndGet(), String.format(template, name));
	}
}
