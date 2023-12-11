package ru.job4j.cars.repository;

import ru.job4j.cars.model.Photo;

import java.util.Collection;
import java.util.Optional;

public interface PhotoRepository {

    Photo savePhoto(Photo photo);

    Optional<Photo> findPhotoById(int id);

    Collection<Photo> findAllPhotos();

    boolean updatePhoto(Photo photo);

    boolean deletePhotoById(int id);
}
