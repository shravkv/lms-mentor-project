package com.bridgelabz.lmsmentor.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Purpose : ResponseClass Used to Handle Exception
 * Version : 1.0
 * @author : Sravan Kumar
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseClass {

    private int errorCode;
    private String message;
    private Object token;
}
