package com.codegym.spring_data_jpa.exception;

public class DuplicateAdminName extends Exception {
    public DuplicateAdminName(String message) {
        super(message);
    }
}
