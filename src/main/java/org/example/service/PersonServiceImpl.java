package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Person;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public Person insert(Person person) {
        return personRepository.save(person);
    }

}
