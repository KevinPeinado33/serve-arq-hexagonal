package pe.edu.upeu.patmosapi.user.domain.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import pe.edu.upeu.patmosapi.config.security.JwtConfig;
import pe.edu.upeu.patmosapi.user.domain.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User create(User user);

    User findByUsername(String userName);

    String getJwtToken(String userName);

}
