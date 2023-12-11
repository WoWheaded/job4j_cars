package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Photo;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimplePhotoRepository implements PhotoRepository {

    private final CrudRepository crudRepository;

    @Override
    public Photo savePhoto(Photo photo) {
        crudRepository.run(session -> session.persist(photo));
        return photo;
    }

    @Override
    public Optional<Photo> findPhotoById(int id) {
        return crudRepository.optional("FROM Photo WHERE id = :fId", Photo.class,
                Map.of("fId", id));
    }

    @Override
    public Collection<Photo> findAllPhotos() {
        return crudRepository.query("FROM Photo ORDER BY id ASC", Photo.class);
    }

    @Override
    public boolean updatePhoto(Photo photo) {
        crudRepository.run(session -> session.merge(photo));
        return true;
    }

    @Override
    public boolean deletePhotoById(int id) {
        crudRepository.run("DELETE FROM Photo WHERE id = :fId",
                Map.of("fId", id));
        return true;
    }
}
