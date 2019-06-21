package com.axxessio.axx2cld.content.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.axxessio.axx2cld.content.entities.SubArea;

@RepositoryRestResource(collectionResourceRel = "subarea", path = "subarea")
public interface SubAreaRepository extends MongoRepository<SubArea, String> {

	Optional<SubArea> findByName(@Param("name") String name);
	Optional<SubArea> findByAreaId(@Param("areaId")String areaId);

}