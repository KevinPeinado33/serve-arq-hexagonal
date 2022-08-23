package pe.edu.upeu.patmosapi.course.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("courses")
public class Course {

    @Id
    private String id;

    private String name;
    private String description;
    private String image;
    private Boolean status;

}
