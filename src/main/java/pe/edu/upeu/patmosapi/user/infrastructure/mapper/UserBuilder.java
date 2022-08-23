package pe.edu.upeu.patmosapi.user.infrastructure.mapper;

import pe.edu.upeu.patmosapi.user.application.request.PersonDto;
import pe.edu.upeu.patmosapi.user.domain.model.User;

public class UserBuilder {

    public static User convertToEntity(
            PersonDto dto
    ) {
        User entity = null;

        if (dto != null) {
            entity = new User();

            if ( dto.getId() != null ) entity.setId( dto.getId() );

            entity.setName( dto.getUserName() );
            entity.setPassword( dto.getPassword() );
            entity.setStatus( dto.getStatus() );

        }

        return entity;

    }
}
