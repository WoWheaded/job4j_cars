package ru.job4j.cars.repository;

import ru.job4j.cars.model.Owner;

import java.util.Collection;
import java.util.Optional;

public interface OwnerRepository {
    Owner saveOwner(Owner owner);

    Optional<Owner> findOwnerById(int id);

    Collection<Owner> findAllOwners();

    boolean updateOwner(Owner owner);

    boolean deleteOwnerById(int id);
}
