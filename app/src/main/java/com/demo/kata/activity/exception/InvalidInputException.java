package com.demo.kata.activity.exception;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }
}
