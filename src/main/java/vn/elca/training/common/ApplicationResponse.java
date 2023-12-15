package vn.elca.training.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApplicationResponse {
    private final String message;
    private final int statusCode;
    private boolean isSuccess = true;
    private Object data = new HashMap<>();

    public Object getData() {
        return data;
    }


    public ApplicationResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public ApplicationResponse(String message, int statusCode, boolean isSuccess) {
        this.message = message;
        this.statusCode = statusCode;
        this.isSuccess = isSuccess;
    }

    public ApplicationResponse(String message, int statusCode, boolean isSuccess, Object data) {
        this.message = message;
        this.statusCode = statusCode;
        this.isSuccess = isSuccess;
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public ResponseEntity<Object> getResponseEntity() {
        return ResponseEntity.status(this.getStatusCode())
                .body(Map.of(
                        "status_code", this.getStatusCode(),
                        "data", this.getData(),
                        "message", this.getMessage(),
                        "success", this.isSuccess()
                ));
    }


    // ResponseMessageType constants
    public static ApplicationResponse CREATED_SUCCESS(Object data) {
        return new ApplicationResponse
                ("Successfully create", HttpStatus.CREATED.value(), true, data);
    }

    public static ApplicationResponse UPDATE_SUCCESS(Object data) {
        return new ApplicationResponse
                ("Successfully update", HttpStatus.OK.value(), true, data);
    }

    public static ApplicationResponse GET_SUCCESS(Object data) {
        return new ApplicationResponse("Successfully get", HttpStatus.OK.value(), true, data);
    }

    public static ApplicationResponse INVALID_JOURNEY_REQUEST(String message) {
        return new ApplicationResponse
                (message, HttpStatus.BAD_REQUEST.value(),
                        false);

    }

    public static ApplicationResponse CONFLICT(String message) {
        return new ApplicationResponse(message, HttpStatus.CONFLICT.value(), false);
    }


    public static final ApplicationResponse DELETE_SUCCESS =
            new ApplicationResponse("Entity is deleted ", HttpStatus.NO_CONTENT.value(),
                    true);

    public static ApplicationResponse JOURNEY_NOT_FOUND(String message) {
        return new ApplicationResponse(message, HttpStatus.NOT_FOUND.value(),
                false);
    }


    public static final ApplicationResponse BAD_REQUEST = new ApplicationResponse("Bad request", HttpStatus.BAD_REQUEST.value(), false);

    public static final ApplicationResponse INTERNAL_SERVER_ERROR = new ApplicationResponse("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);

    public static final ApplicationResponse OPTIMISTIC_LOCKING_FAILURE = new ApplicationResponse("Row was updated or deleted by another transaction", HttpStatus.CONFLICT.value(), false);

}
