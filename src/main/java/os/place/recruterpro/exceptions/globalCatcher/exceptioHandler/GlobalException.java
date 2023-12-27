package os.place.recruterpro.exceptions.globalCatcher.exceptioHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import os.place.recruterpro.exceptions.exception.NotExist;
import os.place.recruterpro.exceptions.exception.OffreCreateException;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(OffreCreateException.class)
    public ResponseEntity<String> handlePostSaveException(OffreCreateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotExist.class)
    public ResponseEntity<String> handleTheExisting(NotExist ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
