package pe.edu.upeu.patmosapi.user.domain.service;

import pe.edu.upeu.patmosapi.user.domain.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User create(User user);

    User findByUsername(String userName);
}
