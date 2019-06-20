package com.axxessio.axx2cld.content.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.axxessio.axx2cld.content.entities.Picture;

@RepositoryRestResource(collectionResourceRel = "picture", path = "picture")
public interface PictureRepository extends MongoRepository<Picture, String> {

	Optional<Picture> findByName(@Param("name") String name);

}