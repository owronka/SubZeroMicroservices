package com.axxessio.axx2cld.content.services.area;

import java.util.List;
import java.util.Optional;

import com.axxessio.axx2cld.content.entities.Area;

public interface AreaService {

	Optional<Area> readByName(String name);

	List<Area> readAll();

	Area create(Area area);

	// Ja oder Nein?
	Boolean delete(String name);

	Area update(Area area);
}
