package com.grupo03.banco.exception;

public class ObjectNotFoundException extends Exception {

    public ObjectNotFoundException(String entityName) {
        super(entityName + " nao encontrado.");
    }

}