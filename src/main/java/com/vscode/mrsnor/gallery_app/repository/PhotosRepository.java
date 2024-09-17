package com.vscode.mrsnor.gallery_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.vscode.mrsnor.gallery_app.model.Photo;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {

}
