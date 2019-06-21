package com.axxessio.axx2cld.content.services.pictures;

import java.util.List;
import java.util.Optional;

import com.axxessio.axx2cld.content.entities.Picture;

public interface PictureService {

	Optional<Picture> readByName(String name);

	Picture create(Picture pic);

	Boolean delete(String id);

}
