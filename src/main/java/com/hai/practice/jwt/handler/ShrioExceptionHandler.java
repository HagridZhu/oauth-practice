package com.hai.practice.jwt.handler;

import com.hai.practice.jwt.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ShrioExceptionHandler {

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Result handle401(ShiroException e) {
        return new Result(401, e.getMessage());
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Result handle401(UnauthorizedException e) {
        return new Result(401, e.getMessage());
    }


    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(UnknownAccountException.class)
    public Result handle403(UnknownAccountException e) {
        return new Result(401, e.getMessage());
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Result globalException(Throwable ex) {
        log.error("", ex);
        return new Result(500, ex.getClass().getTypeName() + ":" + ex.getLocalizedMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }


}
