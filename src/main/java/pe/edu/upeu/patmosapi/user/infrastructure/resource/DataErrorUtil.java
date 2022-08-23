package pe.edu.upeu.patmosapi.user.infrastructure.resource;

import org.springframework.dao.DataAccessException;

public class DataErrorUtil {

    public static String showErrorMsg(DataAccessException e) {
        return e
                .getMessage()
                .concat(": ")
                .concat(
                        e
                            .getMostSpecificCause()
                            .getMessage()
                );
    }

}
