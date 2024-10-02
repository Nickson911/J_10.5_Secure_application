package com.example.secure_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.secure_application.entity.Person;
import com.example.secure_application.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/city/{city}")
    public List<Person> getPersonsByCity(@PathVariable String city) {
        return personRepository.findByCity(city);
    }

    @GetMapping("/age-less-than/{age}")
    public List<Person> getPersonsYoungerThan(@PathVariable int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/name-surname")
    public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Person> person = personRepository.findByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(personDetails.getName());
                    person.setSurname(personDetails.getSurname());
                    person.setCity(personDetails.getCity());
                    person.setAge(personDetails.getAge());
                    return ResponseEntity.ok(personRepository.save(person));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(person -> {
                    personRepository.delete(person);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}