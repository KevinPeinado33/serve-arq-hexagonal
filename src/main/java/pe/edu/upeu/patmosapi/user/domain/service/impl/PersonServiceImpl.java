package pe.edu.upeu.patmosapi.user.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.patmosapi.user.application.request.PersonDto;
import pe.edu.upeu.patmosapi.user.domain.model.Person;
import pe.edu.upeu.patmosapi.user.domain.model.User;
import pe.edu.upeu.patmosapi.user.domain.repository.PersonRepository;
import pe.edu.upeu.patmosapi.user.domain.service.PersonService;
import pe.edu.upeu.patmosapi.user.domain.service.UserService;
import pe.edu.upeu.patmosapi.user.infrastructure.mapper.PersonBuilder;
import pe.edu.upeu.patmosapi.user.infrastructure.mapper.UserBuilder;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Person create(PersonDto personDto) {

        Person newPerson = PersonBuilder.convertToEntity( personDto );
        User newUser     = UserBuilder.convertToEntity( personDto );

        userService.create( newUser );

        return personRepository.insert( newPerson );

    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
