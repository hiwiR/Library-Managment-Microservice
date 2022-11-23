package com.miu.exceptions;

public class BookDoesnotExist extends RuntimeException{
    public BookDoesnotExist(String message){
        super(message);
    }
}
