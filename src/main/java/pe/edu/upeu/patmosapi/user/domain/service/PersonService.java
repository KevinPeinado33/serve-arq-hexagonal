package pe.edu.upeu.patmosapi.user.domain.service;

import pe.edu.upeu.patmosapi.user.application.request.PersonDto;
import pe.edu.upeu.patmosapi.user.domain.model.Person;

import java.util.List;

public interface PersonService {

    Person create(PersonDto personDto);

    List<Person> getAll();
}
