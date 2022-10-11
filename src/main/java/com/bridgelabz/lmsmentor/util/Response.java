package com.bridgelabz.lmsmentor.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response  {

    private int statusCode;
    private String statusMessage;
    private Object object;
}
