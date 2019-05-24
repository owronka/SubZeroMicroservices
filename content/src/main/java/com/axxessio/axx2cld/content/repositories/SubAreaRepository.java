package com.axxessio.axx2cld.content.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axxessio.axx2cld.content.entities.SubArea;

@Repository
public interface SubAreaRepository extends CrudRepository<SubArea, Integer> {

	Optional<SubArea> findByName(String name);

	List<SubArea> findByArea(String area);

}
