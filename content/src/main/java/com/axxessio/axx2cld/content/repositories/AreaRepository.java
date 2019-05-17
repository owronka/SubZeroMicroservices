package com.axxessio.axx2cld.content.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axxessio.axx2cld.content.entities.Area;




@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {

	Optional<Area> findByName(String name);

}
