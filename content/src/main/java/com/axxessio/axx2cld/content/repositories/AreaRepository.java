package com.axxessio.axx2cld.content.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.axxessio.axx2cld.content.entities.Area;

@RepositoryRestResource(collectionResourceRel = "area", path = "area")
public interface AreaRepository extends MongoRepository<Area, String> {

	Optional<Area> findByName(@Param("name") String name);

}
