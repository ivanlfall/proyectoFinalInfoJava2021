package com.ivanlfall.ProyectoFinalInfo2021.exception;

public class EmailExistException extends RuntimeException{
    public EmailExistException(String message){
        super(message);
    }
}
