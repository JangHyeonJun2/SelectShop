package com.sparta.week01.controller;

import com.sparta.week01.domain.CourseRepository;
import com.sparta.week01.domain.Person;
import com.sparta.week01.domain.PersonRepository;
import com.sparta.week01.models.PersonRequestDto;
import com.sparta.week01.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonController(PersonRepository personRepository,PersonService personService) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @GetMapping("/api/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person addPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);//이렇게 해야 personRepository의 save를 사용할 수 있다.
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id,@RequestBody PersonRequestDto requestDto) {
        return personService.update(id,requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
