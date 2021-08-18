package com.vinncorp.hrms.global.exceptions;

public class UserNotAllowedException extends Exception {

    public UserNotAllowedException() {
    }

    public UserNotAllowedException(String message) {
        super(message);
    }

    public UserNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

}

