package com.axxessio.axx2cld.content.services.area;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axxessio.axx2cld.main.content.entities.Area;
import com.axxessio.axx2cld.main.content.repositories.AreaRepository;



@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepository areaRepository;

	@Override
	public Optional<Area> readByName(String name) {

		return areaRepository.findByName(name);
	}

	@Override
	public List<Area> readAll() {

		List<Area> listArea = new ArrayList();
		areaRepository.findAll().forEach(area -> {
			listArea.add(area);
		});
		return listArea;

	}

	@Override
	public Area create(Area area) {
		return areaRepository.save(area);

	}

	@Override
	public Boolean delete(String name) {
		try {
			Area newArea = areaRepository.findByName(name).get();
			areaRepository.delete(newArea);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Area update(Area area) {
		return areaRepository.save(area);
	}

}
