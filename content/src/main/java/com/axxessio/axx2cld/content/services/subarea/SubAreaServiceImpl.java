package com.axxessio.axx2cld.content.services.subarea;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axxessio.axx2cld.main.content.entities.Area;
import com.axxessio.axx2cld.main.content.entities.SubArea;
import com.axxessio.axx2cld.main.content.repositories.AreaRepository;
import com.axxessio.axx2cld.main.content.repositories.SubAreaRepository;



@Service
public class SubAreaServiceImpl implements SubAreaService {

	@Autowired
	private SubAreaRepository subAreaRepository;
	@Autowired
	private AreaRepository areaRepository;

	@Override
	public Optional<SubArea> readByName(String name) {
		// TODO Auto-generated method stub
		return subAreaRepository.findByName(name);
	}

	@Override
	public List<SubArea> readByArea(String area) {

		return subAreaRepository.findByArea(area);
	}

	@Override
	public SubArea create(SubArea subarea) {

		// Subarea nur erstellen, wenn Area vorhanden
		Optional<Area> area = areaRepository.findByName(subarea.getArea());
		if (area.isPresent()) {
			return subAreaRepository.save(subarea);
		}

		return null;
	}

	public SubArea update(SubArea subarea) {

		// Subarea nur erstellen, wenn Area vorhanden
		Optional<Area> area = areaRepository.findByName(subarea.getArea());
		if (area.isPresent()) {
			return subAreaRepository.save(subarea);
		}

		return null;

	}

	@Override
	public Boolean delete(Integer id) {
		try {
			subAreaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
