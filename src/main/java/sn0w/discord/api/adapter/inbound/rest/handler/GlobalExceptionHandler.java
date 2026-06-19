package sn0w.discord.api.adapter.inbound.rest.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sn0w.discord.api.adapter.inbound.rest.dto.WebResponse;
import sn0w.discord.api.core.exception.DomainException;
import sn0w.discord.api.core.exception.agent.AgentNameAlreadyExist;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<WebResponse<String>> validationEx(ConstraintViolationException ex, HttpServletRequest http) {
        List<Map<String, String>> violationList = ex.getConstraintViolations().stream()
                .map(constraintViolation -> {
                    Map<String, String> errorList = new HashMap<>();
                    errorList.put("Field", constraintViolation.getPropertyPath().toString());
                    errorList.put("Message", constraintViolation.getMessage());
                    return errorList;
                }).toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(WebResponse.<String>builder()
                        .metadata(WebResponse.Metadata.builder()
                                .requestId(UUID.randomUUID().toString())
                                .timestamp(OffsetDateTime.now().toString())
                                .path(http.getRequestURI())
                                .build())
                        .errors(WebResponse.Errors.builder()
                                .errorCode("VALIDATION_ERROR")
                                .errorMessage("Validation error")
                                .details(violationList)
                                .build())
                        .build());
    }

    @ExceptionHandler({AgentNameAlreadyExist.class})
    public ResponseEntity<WebResponse<String>> handleUserConflictExceptions(DomainException ex, HttpServletRequest http) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(WebResponse.<String>builder()
                        .metadata(WebResponse.Metadata.builder()
                                .requestId(UUID.randomUUID().toString())
                                .timestamp(OffsetDateTime.now().toString())
                                .path(http.getRequestURI())
                                .build())
                        .errors(WebResponse.Errors.builder()
                                .errorCode(ex.getCode())
                                .errorMessage(ex.getMessage())
                                .build())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<WebResponse<String>> handleGenericException(Exception ex, HttpServletRequest http) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(WebResponse.<String>builder()
                        .metadata(WebResponse.Metadata.builder()
                                .requestId(UUID.randomUUID().toString())
                                .timestamp(OffsetDateTime.now().toString())
                                .path(http.getRequestURI())
                                .build())
                        .errors(WebResponse.Errors.builder()
                                .errorCode("Internal Server Error")
                                .errorMessage("Internal server error")
                                .build())
                        .build());
    }

}
