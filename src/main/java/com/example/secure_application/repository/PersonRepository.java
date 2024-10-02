package com.example.secure_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.secure_application.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    List<Person> findByCity(@Param("city") String city);


    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") int age);


    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}