package com.wsdev.Client.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomErrors{
    private List<FieldErrorMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldErrorMessage> getErrors() {
        return errors;
    }
    public void addError(String fieldName,String message){
        errors.add(new FieldErrorMessage(fieldName, message));
    }
}
