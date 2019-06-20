package com.axxessio.axx2cld.content.services.pictures;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axxessio.axx2cld.content.entities.Picture;
import com.axxessio.axx2cld.content.entities.SubArea;
import com.axxessio.axx2cld.content.repositories.PictureRepository;
import com.axxessio.axx2cld.content.repositories.SubAreaRepository;

@Service
public class PictureServiceImpl implements PictureService {
	
	/*
	 * Erzeugung SubAreaRepository;
	 * Erzeugung PictureRepository;
	 */
	@Autowired
	private SubAreaRepository subAreaRepository;
	private PictureRepository pictureRepository;

	/*
	 * Methode um Pictures über den Subareaname zu suchen;
	 */
	@Override
	public Optional<Picture> readByName(String name) {

		return pictureRepository.findByName(name);
	}
	
	/*
	 * Methode zum Erstellen eines Bildes;
	 * Vorhergehender Check ob entsprechende Subarea existiert;
	 */
	@Override
	public Picture create(Picture pic) {

		Optional<SubArea> subarea = subAreaRepository.findByName(pic.getSubareaId());
		if (subarea.isPresent()) {
			pictureRepository.save(pic);
		}

		return null;
	}
	
	/*
	 * Methode zum Löschen eines Pictures über dessen ID;
	 * Try-Catch-Block um Existenz zu checken;
	 */
	@Override
	public Boolean delete(String id) {
		try {
			pictureRepository.deleteById(id);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
