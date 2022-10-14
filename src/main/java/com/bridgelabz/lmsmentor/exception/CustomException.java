package com.bridgelabz.lmsmentor.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Purpose : CustomExceptions are Used to Validate exception
 * Version : 1.0
 * @author : Sravan Kumar
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException {

    private int errorCode;
    private String message;
}
