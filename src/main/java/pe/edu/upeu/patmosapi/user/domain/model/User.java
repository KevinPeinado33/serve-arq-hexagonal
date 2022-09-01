package pe.edu.upeu.patmosapi.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class User {

    @Id
    private String id;

    private String name;
    private String password;
    private Boolean status;
    private String token;
    private List<Rol> roles;

}
