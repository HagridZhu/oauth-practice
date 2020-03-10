package com.hai.practice.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {


    private int status;
    private String message;
    private T data;

    public Result(int status, String message){
        this.status = status;
        this.message = message;
    }




}
