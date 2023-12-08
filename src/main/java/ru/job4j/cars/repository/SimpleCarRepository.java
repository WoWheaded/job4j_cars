package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimpleCarRepository implements CarRepository {

    private final CrudRepository crudRepository;

    @Override
    public Car saveCar(Car car) {
        crudRepository.run(session -> session.persist(car));
        return car;
    }

    @Override
    public Collection<Car> findAllCars() {
        return crudRepository.query("FROM Car ORDER BY id ASC", Car.class);
    }

    @Override
    public Optional<Car> findCarById(int id) {
        return crudRepository.optional("FROM Car WHERE id = :fId", Car.class,
                Map.of("fId", id));
    }

    @Override
    public boolean updateCar(Car car) {
        crudRepository.run(session -> session.merge(car));
        return true;
    }

    @Override
    public boolean deleteCarById(int id) {
        crudRepository.run("DELETE FROM Car WHERE id = :fId",
                Map.of("fId", id));
        return true;
    }
}
