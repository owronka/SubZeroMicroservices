package com.axxessio.axx2cld.content.controll;

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

import com.axxessio.axx2cld.main.content.entities.SubArea;
import com.axxessio.axx2cld.main.content.services.subarea.SubAreaService;



@RestController
@RequestMapping("/content/subareas")
public class SubAreaController {
	@Autowired
	private SubAreaService subareaService;

	@PostMapping
	public ResponseEntity<SubArea> create(@RequestBody(required = true) SubArea subarea) {
		if (subarea == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SubArea>(subareaService.create(subarea), HttpStatus.OK);
	}

	@GetMapping("/area/{name}")
	public ResponseEntity<List<SubArea>> readByArea(@PathVariable(name = "name") String name) {

		return new ResponseEntity<List<SubArea>>(subareaService.readByArea(name), HttpStatus.OK);

	}

	@GetMapping("/{name}")
	public ResponseEntity<SubArea> readByName(@PathVariable(name = "name") String name) {

		Optional<SubArea> subarea = subareaService.readByName(name);
		if (subarea.isPresent()) {
			return new ResponseEntity<SubArea>(subarea.get(), HttpStatus.OK);

		}
		return new ResponseEntity<SubArea>(HttpStatus.NOT_FOUND);
	}

	@PutMapping
	public ResponseEntity<SubArea> update(@RequestBody(required = true) SubArea subarea) {
		if (subarea == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SubArea>(subareaService.update(subarea), HttpStatus.OK);
	}

	@DeleteMapping(params = "id")
	public ResponseEntity<Boolean> delete(@RequestParam(required = true, value = "id") Integer id) {

		return new ResponseEntity<Boolean>(subareaService.delete(id), HttpStatus.OK);

	}

}
