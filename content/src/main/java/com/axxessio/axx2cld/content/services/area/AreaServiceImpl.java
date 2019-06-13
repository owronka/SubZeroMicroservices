package com.axxessio.axx2cld.content.services.area;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axxessio.axx2cld.content.entities.Area;
import com.axxessio.axx2cld.content.repositories.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService {

	/*
	 * Erzeugung eines Area-Repositories;
	 */
	@Autowired
	private AreaRepository areaRepository;

	/*
	 * Methode um Areas über den Namen zu suchen;
	 */
	@Override
	public Optional<Area> readByName(String name) {

		return areaRepository.findByName(name);
	}

	/*
	 * Methode zur Ausgabe aller Areas in einer Liste von Areas;
	 */
	@Override
	public List<Area> readAll() {

		/*
		 * neue ArrayList wird erzeugt und durch ein forEach befüllt;
		 */
		List<Area> listArea = new ArrayList();
		areaRepository.findAll().forEach(area -> {
			listArea.add(area);
		});
		return listArea;

	}

	/*
	 * Methode zum Erstellen einer Area;
	 */
	@Override
	public Area create(Area area) {
		return areaRepository.save(area);

	}

	/*
	 * Delete Methode. Try-Catch-Block um zu checken ob angegebener Name existiert;
	 */
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

	/*
	 * Methode zum Area updaten; Eigentlich das gleiche wie create;
	 */
	@Override
	public Area update(Area area) {
		return areaRepository.save(area);
	}

}
