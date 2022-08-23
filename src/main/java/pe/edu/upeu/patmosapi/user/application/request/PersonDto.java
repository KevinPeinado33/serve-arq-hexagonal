package pe.edu.upeu.patmosapi.user.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
    private String id;

    private String name;
    private String lastName;
    private String dni;
    private Integer age;
    private Boolean status;
    private String userName;
    private String password;
}
