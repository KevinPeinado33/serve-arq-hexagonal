package pe.edu.upeu.patmosapi.user.application.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.patmosapi.user.domain.model.User;
import pe.edu.upeu.patmosapi.user.domain.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/users")
@Api(value = "/api/users", tags = "Operaciones Usuario")
public class UserController {

    private static final Integer DATA_EMPTY = 0;

    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity< ? > getAll() {

        Map<String, Object> response = new HashMap<>();
        List<User> users             = null;

        try {
            users = userService.getAll();
        } catch (DataAccessException e) {

            response.put("msg", "Error al obtener usuarios");
            response.put(
                    "error",
                    e
                        .getMessage()
                        .concat(": ")
                        .concat(
                                e
                                    .getMostSpecificCause()
                                    .getMessage()
                        )
            );

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        if (users == null || DATA_EMPTY == users.size()) {
            response.put("msg", "Lista de usuario vacia.");
            response.put("users", users);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("msg", "Obtencion correcta");
        response.put("users", users);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

}
