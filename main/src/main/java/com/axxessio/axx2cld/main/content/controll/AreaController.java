package com.axxessio.axx2cld.main.content.controll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axxessio.axx2cld.main.content.entities.Area;
import com.axxessio.axx2cld.main.content.services.area.AreaService;


@RestController
@RequestMapping("/content/areas")
public class AreaController {
	
	@Autowired
	private AreaService areaService;

	@PostMapping
	public ResponseEntity<Area> create(@RequestBody(required = true) Area area) {
		if (area == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Area>(areaService.create(area), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Area>> readAll() {

		return new ResponseEntity<List<Area>>(areaService.readAll(), HttpStatus.OK);

	}

	@GetMapping("/{name}")
	public ResponseEntity<Area> readByName(@PathVariable(name = "name") String name) {

		Optional<Area> area = areaService.readByName(name);
		if (area.isPresent()) {
			return new ResponseEntity<Area>(area.get(), HttpStatus.OK);

		}
		return new ResponseEntity<Area>(HttpStatus.NOT_FOUND);
	}

	@PutMapping
	public ResponseEntity<Area> update(@RequestBody(required = true) Area area) {
		if (area == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Area>(areaService.update(area), HttpStatus.OK);
	}

	@DeleteMapping(params = "name")
	public ResponseEntity<Boolean> delete(@RequestParam(required = true, value = "name") String name) {

		return new ResponseEntity<Boolean>(areaService.delete(name), HttpStatus.OK);

	}

}
