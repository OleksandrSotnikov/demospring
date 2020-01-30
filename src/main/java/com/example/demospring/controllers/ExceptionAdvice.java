package com.example.demospring.controllers;

import com.example.demospring.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public MyError impossibleDelete(ImpossibleToDeleteException ex) {
        return new MyError(ex.getCode(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MyError unacceptableEntity(UnprocessableEntityException ex){
        return new MyError(ex.getCode(), ex.getMessage());
    }

}

