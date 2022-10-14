package com.bridgelabz.lmsmentor.exception;


import org.springframework.web.bind.annotation.ResponseStatus;


/*
 * Purpose : LMSExceptions are used to Handle the Exceptions
 * Version : 1.0
 * @author : Sravan Kumar
 * */
@ResponseStatus
public class LMSException extends RuntimeException {
    private int statusCode;
    private String statusMessage;

    public LMSException(int statusCode, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

}
