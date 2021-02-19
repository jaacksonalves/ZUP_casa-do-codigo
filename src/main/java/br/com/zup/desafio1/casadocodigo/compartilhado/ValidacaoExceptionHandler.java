package br.com.zup.desafio1.casadocodigo.compartilhado;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidacaoExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidacaoExceptionDto> validarMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ValidacaoExceptionDto ved = new ValidacaoExceptionDto();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        ved.setTitulo(fields);
        ved.setDetalhe(fieldMessage);
        ved.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
        ved.setHora(LocalDateTime.now(ZoneId.of("UTC")));

        return new ResponseEntity<>(ved, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidacaoExceptionDto> validarValidationException(ValidationException ex) {
        ValidacaoExceptionDto ved = new ValidacaoExceptionDto();

        ved.setTitulo(ex.getCause().toString());
        ved.setDetalhe(ex.getMessage());
        ved.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
        ved.setHora(LocalDateTime.now(ZoneId.of("UTC")));

        return new ResponseEntity<>(ved, HttpStatus.BAD_REQUEST);
    }


}