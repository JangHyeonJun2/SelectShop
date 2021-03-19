package com.sparta.week01.controller;

import com.sparta.week01.domain.Person;
import com.sparta.week01.domain.PersonRepository;
import com.sparta.week01.models.PersonRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonControllerTest {
    @Autowired
    PersonController personController;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void getTest() {
        personRepository.save(new Person(1L,"장장이","대구",27));
        List<Person> persons = personController.getPersons();
        Assertions.assertThat(persons.get(0).getName()).isEqualTo("장장이");
    }
}