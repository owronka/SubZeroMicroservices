package com.axxessio.axx2cld.content.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axxessio.axx2cld.content.entities.Picture;



@Repository
public interface PictureRepository extends CrudRepository<Picture, Integer> {
	
	List<Picture> findBySubarea(String subarea);

}
