package com.cyeproject.croissantbakery.exception;

import lombok.Getter;

public enum ExceptionCode {
    NOT_FOUND(404,"Content Not Found"),
    ALREADY_EXISTS(409,"Content Already exist");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status=status;
        this.message=message;
    }
}
