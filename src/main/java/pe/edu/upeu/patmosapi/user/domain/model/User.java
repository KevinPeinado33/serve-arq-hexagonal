package pe.edu.upeu.patmosapi.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
