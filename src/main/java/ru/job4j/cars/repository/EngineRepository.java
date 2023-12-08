package ru.job4j.cars.repository;

import ru.job4j.cars.model.Engine;

import java.util.Collection;
import java.util.Optional;

public interface EngineRepository {
    Engine saveEngine(Engine engine);

    Optional<Engine> findEngineById(int id);

    Collection<Engine> findAllEngines();

    boolean updateEngine(Engine engine);

    boolean deleteEngineById(int id);
}
