package vn.elca.training.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.hibernate.HibernateException;
import org.hibernate.StaleObjectStateException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import vn.elca.training.common.ApplicationResponse;

import javax.persistence.EntityNotFoundException;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;


@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({IllegalArgumentException.class,
            HttpMessageNotReadableException.class,
            InvalidFormatException.class,
            NumberFormatException.class,
            DateTimeException.class,
            IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception) {
        logger.error(exception.getMessage(), exception);
        return ApplicationResponse.INVALID_JOURNEY_REQUEST(exception.getMessage()).getResponseEntity();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleJourneyNotFoundException(EntityNotFoundException exception) {
        logger.error(exception.getMessage(), exception);
        return ApplicationResponse.JOURNEY_NOT_FOUND(exception.getMessage()).getResponseEntity();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleUnexpectedException(Exception exception) {
        logger.error(exception.getMessage(), exception);
        return ApplicationResponse.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @ExceptionHandler(StaleObjectStateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleOptimisticLockingFailure(StaleObjectStateException exception) {
        logger.error(exception.getMessage(), exception);
        return ApplicationResponse.OPTIMISTIC_LOCKING_FAILURE.getResponseEntity();
    }
}
