package com.axxessio.axx2cld.main.content.services.subarea;

import java.util.List;
import java.util.Optional;

import com.axxessio.axx2cld.main.content.entities.SubArea;



public interface SubAreaService {

	Optional<SubArea> readByName(String name);

	List<SubArea> readByArea(String area);

	SubArea create(SubArea subarea);
	
	SubArea update(SubArea subarea);

	Boolean delete(Integer id);

}
