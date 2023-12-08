package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Owner;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimpleOwnerRepository implements OwnerRepository {

    private final CrudRepository crudRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        crudRepository.run(session -> session.persist(owner));
        return owner;
    }

    @Override
    public Optional<Owner> findOwnerById(int id) {
        return crudRepository.optional("FROM Owner WHERE id = :fId", Owner.class,
                Map.of("fId", id));
    }

    @Override
    public Collection<Owner> findAllOwners() {
        return crudRepository.query("FROM Owner ORDER BY id ASC", Owner.class);
    }

    @Override
    public boolean updateOwner(Owner owner) {
        crudRepository.run(session -> session.merge(owner));
        return true;
    }

    @Override
    public boolean deleteOwnerById(int id) {
        crudRepository.run("DELETE FROM Owner WHERE id = :fId",
                Map.of("fId", id));
        return true;

    }
}
