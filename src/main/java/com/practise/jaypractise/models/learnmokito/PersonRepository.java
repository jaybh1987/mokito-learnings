package com.practise.jaypractise.models.learnmokito;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person Save(Person person);
    Optional<Person> findById(int id);
    List<Person> findAll();
    long count();
    void delete(Person person);
}
