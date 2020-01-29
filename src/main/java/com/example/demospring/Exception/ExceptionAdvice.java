package com.example.demospring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MyError notFound(NotFoundException ex) {

        return new MyError(ex.getCode(), ex.getMessage());

    }

    @ResponseBody
    @ExceptionHandler(DoesNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MyError notExist(DoesNotExistException ex) {

        return new MyError(ex.getCode(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ImpossibleToDeleteException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public MyError ImpossibleDelete(ImpossibleToDeleteException ex) {
        return new MyError(ex.getCode(), ex.getMessage());
    }

}

