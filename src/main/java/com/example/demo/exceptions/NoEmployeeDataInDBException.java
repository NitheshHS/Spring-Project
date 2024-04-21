package com.example.demo.exceptions;

public class NoEmployeeDataInDBException extends RuntimeException{
    public NoEmployeeDataInDBException() {
    }

    public NoEmployeeDataInDBException(String message) {
        super(message);
    }

    public NoEmployeeDataInDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEmployeeDataInDBException(Throwable cause) {
        super(cause);
    }

    public static class EmployeeNotFoundException extends  RuntimeException{
        public EmployeeNotFoundException() {
        }

        public EmployeeNotFoundException(String message) {
            super(message);
        }

        public EmployeeNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public EmployeeNotFoundException(Throwable cause) {
            super(cause);
        }
    }
}
