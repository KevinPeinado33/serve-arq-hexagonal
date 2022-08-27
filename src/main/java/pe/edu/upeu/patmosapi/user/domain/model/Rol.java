package pe.edu.upeu.patmosapi.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("roles")
public class Rol {

    @Id
    private String id;

    private String name;
    private Boolean state;
}
