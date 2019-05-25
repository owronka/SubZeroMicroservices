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

	@Autowired
	private SubAreaRepository subAreaRepository;
	private PictureRepository pictureRepository;

	@Override
	public List<Picture> readBySubarea(String name) {

		return pictureRepository.findBySubarea(name);
	}

	@Override
	public Picture create(Picture pic) {

		Optional<SubArea> subarea = subAreaRepository.findByName(pic.getSubarea());
		if (subarea.isPresent()) {
			pictureRepository.save(pic);
		}

		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			pictureRepository.deleteById(id);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
