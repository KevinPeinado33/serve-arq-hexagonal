package pe.edu.upeu.patmosapi.user.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.patmosapi.user.domain.model.User;
import pe.edu.upeu.patmosapi.user.domain.repository.UserRepository;
import pe.edu.upeu.patmosapi.user.domain.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.insert( user );
    }

}
