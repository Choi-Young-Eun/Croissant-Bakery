package com.cyeproject.croissantbakery.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private Integer status;
    private String message;
    private List<FieldError> fieldErrors;

    private ErrorResponse(final List<FieldError> fieldErrors,final Integer status,final String message){
        this.fieldErrors=fieldErrors;
        this.status=status;
        this.message=message;
    }

    public static ErrorResponse of(BindingResult bindingResult, HttpStatus httpStatus){
        return new ErrorResponse(FieldError.of(bindingResult), httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public static ErrorResponse of(HttpStatus httpStatus){
        return new ErrorResponse(null, httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public static ErrorResponse of(ExceptionCode exceptionCode){
        return new ErrorResponse(null, exceptionCode.getStatus(), exceptionCode.getMessage());
    }
    @Getter
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field,Object rejectedValue, String reason){
            this.field=field;
            this.rejectedValue=rejectedValue;
            this.reason=reason;
        }
        public static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> errors = bindingResult.getFieldErrors();

            return errors.stream()
                            .map(error -> new ErrorResponse.FieldError(
                                    error.getField(),
                                    error.getRejectedValue() == null ?
                                            "" : error.getRejectedValue().toString(),
                                    error.getDefaultMessage()))
                            .collect(Collectors.toList());
        }
    }
}
