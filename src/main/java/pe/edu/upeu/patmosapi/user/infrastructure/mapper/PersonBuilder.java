package pe.edu.upeu.patmosapi.user.infrastructure.mapper;

import pe.edu.upeu.patmosapi.user.application.request.PersonDto;
import pe.edu.upeu.patmosapi.user.domain.model.Person;

public class PersonBuilder {

    public static Person convertToEntity(
            PersonDto personDto
    ) {

        Person person = null;

        if (personDto != null) {

            person = new Person();

            if (personDto.getId() != null) person.setId(personDto.getId());

            person.setName(personDto.getName());
            person.setLastName(personDto.getLastName());
            person.setAge(personDto.getAge());
            person.setDni(personDto.getDni());
            person.setStatus(personDto.getStatus());

        }

        return person;

    }
}
