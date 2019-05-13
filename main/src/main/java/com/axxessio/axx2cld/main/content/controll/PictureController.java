package com.axxessio.axx2cld.main.content.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axxessio.axx2cld.main.content.entities.Picture;
import com.axxessio.axx2cld.main.content.services.picture.PictureService;


@RestController
@RequestMapping("/content/pictures")
public class PictureController {
	@Autowired
	private PictureService pictureService;

	@PostMapping
	public ResponseEntity<Picture> create(@RequestBody(required = true) Picture picture) {
		if (picture == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Picture>(pictureService.create(picture), HttpStatus.OK);
	}

	@GetMapping("/subarea/{name}")
	public ResponseEntity<List<Picture>> readBySubArea(@PathVariable(name = "name") String name) {

		return new ResponseEntity<List<Picture>>(pictureService.readBySubarea(name), HttpStatus.OK);

	}
	/*
	 * @PutMapping public ResponseEntity<SubArea> update(@RequestBody(required =
	 * true) SubArea subarea) { if (subarea == null) { return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } return new
	 * ResponseEntity<SubArea>(subareaService.update(subarea), HttpStatus.OK); }
	 */

	@DeleteMapping(params = "id")
	public ResponseEntity<Boolean> delete(@RequestParam(required = true, value = "id") Integer id) {

		return new ResponseEntity<Boolean>(pictureService.delete(id), HttpStatus.OK);

	}

}
