package com.cyeproject.croissantbakery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


@RestControllerAdvice //@ControllerAdvice + @ResponseBody
public class GlobalExceptionAdvice {
    //1. RequestBody의 유효성 검사! - 현재는 postCroissant에 적용됨
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        final ErrorResponse errorResponse = ErrorResponse.of(e.getBindingResult(), HttpStatus.BAD_REQUEST);
        return errorResponse;
    }

    //2. 메서드가 잘못왔을때 (처리할 핸들러 메서드가 없는 경우겠지요?)
    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        final ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.METHOD_NOT_ALLOWED);
        return errorResponse;
    }

    //3. 컨텐츠가 없을때 (그러니까 잘못된 URI가 전달된! 그래서 DB에 데이터가 존재하지 않는 경우겠지요?)
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleHttpRequestNotFoundException(NoHandlerFoundException e){
        final ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.NOT_FOUND);
        return errorResponse;
    }
}
