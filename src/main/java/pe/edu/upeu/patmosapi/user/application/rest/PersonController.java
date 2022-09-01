package pe.edu.upeu.patmosapi.user.application.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "/api/persons", tags = "Operaciones Persona")
public class PersonController {

    private final static String MSG              = "msg";
    private final static String ERROR            = "error";
    private static final String DATA_PERSON      = "persona";
    private static final String DATA_LIST_PERSON = "personas";

    @Autowired
    private PersonService personService;

    @ApiOperation(
            value = "Obtener todos los usuarios / personas",
            nickname = "Obtener todas las personas",
            response = Long.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Todo correcto p!"),
            @ApiResponse(code = 500, message = "Error del servidor."),
            @ApiResponse(code = 404, message = "No se encontró nada pipipiip.")
    })
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

        if (persons == null) {
            response.put(MSG,"No se encontró ninguna persona");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put(MSG, "Se hán obtenido las 10 primeras personas.");
        response.put(DATA_LIST_PERSON, persons);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }


    @ApiOperation(
            value = "Creación de la persona, sumado a eso el usuario.",
            nickname = "Crear nueva persona",
            response = Long.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Creado correctamente uwu!"),
            @ApiResponse(code = 500, message = "Error del servidor.")
    })
    @PostMapping("/create")
    private ResponseEntity< ? > create(
            @RequestBody
            PersonDto personDto
    ) {

        Map<String, Object> response = new HashMap<>();
        Person person                = null;

        try {
            person = personService.create(personDto);
        } catch (DataAccessException e) {

            response.put(MSG, "Error al crear la persona");
            response.put(ERROR, DataErrorUtil.showErrorMsg( e ));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("msg", "Persona creada correctamente!");
        response.put(DATA_PERSON, person);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

}
