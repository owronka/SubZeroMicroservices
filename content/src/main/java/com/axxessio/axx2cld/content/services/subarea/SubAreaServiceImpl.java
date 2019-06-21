package com.axxessio.axx2cld.content.services.subarea;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axxessio.axx2cld.content.entities.Area;
import com.axxessio.axx2cld.content.entities.SubArea;
import com.axxessio.axx2cld.content.repositories.AreaRepository;
import com.axxessio.axx2cld.content.repositories.SubAreaRepository;

@Service
public class SubAreaServiceImpl implements SubAreaService {

	/*
	 * Erzeugung: SubAreaRepository; Erzeugung: AreaRepository;
	 */
	@Autowired
	private SubAreaRepository subAreaRepository;
	@Autowired
	private AreaRepository areaRepository;

	/*
	 * Methode um SubAreas über den Namen zu suchen;
	 */
	@Override
	public Optional<SubArea> readByName(String name) {

		return subAreaRepository.findByName(name);
	}

	/*
	 * Methode um SubAreas über eine Area zu suchen;
	 */
	@Override
	public Optional<SubArea> readByArea(String area) {

		return subAreaRepository.findByAreaId(area);
	}

	/*
	 * Methode zu Erstellung einer SubArea. Vorhergehender Check, ob entsprechende
	 * Area vorhanden ist;
	 */
	@Override
	public SubArea create(SubArea subarea) {

		Optional<Area> area = areaRepository.findByName(subarea.getAreaId());
		if (area.isPresent()) {
			return subAreaRepository.save(subarea);
		}

		return null;
	}

	/*
	 * Update einer SubArea; Check, ob entsprechende Area vorhanden;
	 */
	public SubArea update(SubArea subarea) {

		Optional<Area> area = areaRepository.findByName(subarea.getAreaId());
		if (area.isPresent()) {
			return subAreaRepository.save(subarea);
		}

		return null;

	}

	/*
	 * Delete Methode über ID. Nur moeglich, wenn vorhanden;
	 */
	@Override
	public Boolean delete(String id) {
		try {
			subAreaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
