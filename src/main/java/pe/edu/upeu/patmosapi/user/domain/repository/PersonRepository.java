package pe.edu.upeu.patmosapi.user.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.upeu.patmosapi.user.domain.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
}
