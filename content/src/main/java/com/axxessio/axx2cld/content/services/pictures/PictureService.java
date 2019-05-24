package com.axxessio.axx2cld.content.services.pictures;

import java.util.List;

import com.axxessio.axx2cld.content.entities.Picture;

public interface PictureService {

	List<Picture> readBySubarea(String name);

	Picture create(Picture pic);

	Boolean delete(Integer id);

}
