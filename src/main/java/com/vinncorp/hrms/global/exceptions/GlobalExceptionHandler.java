package com.vinncorp.hrms.global.exceptions;

import com.vinncorp.hrms.global.Message;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity<Object> handleRecordNotFound(RecordNotFoundException ex){
        Message message = new Message();
        message.setMessage(ex.getMessage()).setStatus(404).setCode("Failure");
        return ResponseEntity.status(message.getStatus()).body(message);
    }

    @ExceptionHandler(UserNotAllowedException.class)
    protected ResponseEntity<Object> handleUserNotAllowed(UserNotAllowedException ex){
        Message message = new Message();
        message.setMessage(ex.getMessage()).setStatus(404).setCode("Failure");
        return ResponseEntity.status(message.getStatus()).body(message);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> map = new HashMap<>();

        ex.getBindingResult().getAllErrors().stream().forEach(e->{

            Object[] obj = e.getArguments();
            map.put(((DefaultMessageSourceResolvable) obj[0]).getCode(), e.getDefaultMessage());
        });

        Message m = new Message();
        m.setMessage("Validation Failed").setStatus(400).setCode("Failure").setData(map);
        return ResponseEntity.status(400)
                .body(m);
    }
}

