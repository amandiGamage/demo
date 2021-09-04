package com.example.demo.exception;

public class SystemException extends RuntimeException{

    private String errorCode = "SYS-0000";
    public SystemException(String message) {
        super(message);
        this.errorCode = "SYS-0000";
    }

    public SystemException(String errorCode, String message) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
