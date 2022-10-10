package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Person;
import org.example.rest.dto.PersonDto;
import org.example.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public PersonDto insertPerson(@RequestBody PersonDto personDto){
        Person person = personService.insert(PersonDto.toDomainObject(personDto,
                Collections.emptyList()));
        return PersonDto.toDto(person);
    }

}
