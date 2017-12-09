package com.fsd.core.services.libraryservice.exception;

public class ResourceNotFoundException extends RuntimeException {

    private Integer resourceId;

    public ResourceNotFoundException(Integer resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}