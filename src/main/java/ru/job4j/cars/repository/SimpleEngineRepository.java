package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimpleEngineRepository implements EngineRepository {

    private final CrudRepository crudRepository;

    @Override
    public Engine saveEngine(Engine engine) {
        crudRepository.run(session -> session.persist(engine));
        return engine;
    }

    @Override
    public Optional<Engine> findEngineById(int id) {
        return crudRepository.optional(
                "FROM Engine WHERE id = :fId", Engine.class,
                Map.of("fId", id)
        );
    }

    @Override
    public Collection<Engine> findAllEngines() {
        return crudRepository.query("FROM Engine ORDER BY id ASC", Engine.class);
    }

    @Override
    public boolean updateEngine(Engine engine) {
        crudRepository.run(session -> session.merge(engine));
        return true;
    }

    @Override
    public boolean deleteEngineById(int id) {
        crudRepository.run(
                "DELETE FROM Engine WHERE id = :fId",
                Map.of("fId", id)
        );
        return true;
    }
}
