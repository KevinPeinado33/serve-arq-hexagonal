package pe.edu.upeu.patmosapi.user.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.upeu.patmosapi.user.domain.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
}
