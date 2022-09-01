package pe.edu.upeu.patmosapi.user.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.patmosapi.config.security.JwtConfig;
import pe.edu.upeu.patmosapi.user.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import pe.edu.upeu.patmosapi.user.domain.repository.UserRepository;
import pe.edu.upeu.patmosapi.user.domain.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {

        User user = userRepository.findByName( username );

        if ( user == null ) {

            System.out.println("Error: El usuario no existe en el sistema.");

            throw new UsernameNotFoundException( "Error: no existe el usuario en el sistema" );

        }

        List< GrantedAuthority > authorities = user
                .getRoles()
                .stream()
                .map( role -> new SimpleGrantedAuthority( role.getName() ) )
                .peek( authority -> System.out.println( "Role: " + authority.getAuthority() ) )
                .collect( Collectors.toList() );

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                user.getStatus(),
                true,
                true,
                true,
                authorities
        );

    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByName( userName );
    }

    @Override
    public String getJwtToken(String userName)  {

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        return JwtConfig.KEY_SECRET;

    }

}
