package com.axxessio.axx2cld.main.content.services.picture;

import java.util.List;

import com.axxessio.axx2cld.main.content.entities.Picture;


public interface PictureService {

	List<Picture> readBySubarea(String name);

	Picture create(Picture pic);

	Boolean delete(Integer id);

}
