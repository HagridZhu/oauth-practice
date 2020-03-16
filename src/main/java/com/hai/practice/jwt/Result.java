package com.hai.practice.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {


    private int code;
    private String message;
    private T data;

    public Result(int code, String message){
        this.code = code;
        this.message = message;
    }

    public static Result error(String message){
        return new Result(500, message);
    }
    public static <T> Result success(T data){
        return new Result<T>(200, "success", data);
    }





}
