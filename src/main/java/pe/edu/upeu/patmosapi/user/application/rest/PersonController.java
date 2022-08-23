package pe.edu.upeu.patmosapi.user.application.rest;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.patmosapi.user.application.request.PersonDto;
import pe.edu.upeu.patmosapi.user.domain.model.Person;
import pe.edu.upeu.patmosapi.user.domain.service.PersonService;
import pe.edu.upeu.patmosapi.user.infrastructure.resource.DataErrorUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/persons")
public class PersonController {

    private final static String MSG              = "msg";
    private final static String ERROR            = "error";
    private static final String DATA_PERSON      = "persona";
    private static final String DATA_LIST_PERSON = "personas";

    @Autowired
    private PersonService personService;

    @GetMapping
    private ResponseEntity< ? > getAll() {

        Map<String, Object> response = new HashMap<>();
        List<Person> persons         = null;

        try {
            persons = personService.getAll();
        } catch (DataAccessException e) {

            response.put(MSG, "Error interno al obtener el listado de personas");
            response.put(ERROR, DataErrorUtil.showErrorMsg( e ));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put(MSG, "Se hán obtenido las primeras 2 personas");
        response.put(DATA_LIST_PERSON, persons);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }


    @PostMapping("/create")
    private ResponseEntity< ? > create(
            @RequestBody
            PersonDto personDto
    ) {

        System.out.println("Persona -> " + personDto.toString());
        Map<String, Object> response = new HashMap<>();
        Person person                = null;

        try {
            person = personService.create(personDto);
        } catch (DataAccessException e) {

            response.put(MSG, "Error al crear la persona");
            response.put(ERROR,DataErrorUtil.showErrorMsg( e ));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("msg", "Persona creada correctamente!");
        response.put(DATA_PERSON, person);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

}
