package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class SimplePostRepository implements PostRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<Post> findAllPostsForLastDay() {
        return crudRepository.query(
                "FROM Post WHERE created = :fDateCreated", Post.class,
                Map.of("fDateCreated", LocalDateTime.now().minusDays(1))
        );
    }

    @Override
    public List<Post> findAllPostsWithPhoto() {
        return crudRepository.query("FROM Post WHERE car.photos.size > 0", Post.class);
    }

    @Override
    public List<Post> findAllCarsByModel(String model) {
        return crudRepository.query("FROM Post WHERE car.name = :fName", Post.class,
                Map.of("fName", model)
        );
    }
}
