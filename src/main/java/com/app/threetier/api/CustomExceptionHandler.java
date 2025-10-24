package com.app.threetier.api;

import com.app.threetier.domain.dto.ApiResponseDTO;
import com.app.threetier.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(MemberException.class)
    protected ResponseEntity<ApiResponseDTO<Object>> memberExceptionHandler(MemberException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        if(e instanceof MemberJoinException){
            status = HttpStatus.CONFLICT;
        }else if(e instanceof MemberLoginException){
            status = HttpStatus.UNAUTHORIZED;
        }else if(e instanceof MemberModifyException){
            status = HttpStatus.BAD_REQUEST;
        }else if(e instanceof MemberWithdrawException){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(ApiResponseDTO.of(e.getMessage()));
    }

    @ExceptionHandler(PostException.class)
    protected ResponseEntity<ApiResponseDTO<Object>> postExceptionHandler(PostException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        if(e instanceof PostWriteException){
            status = HttpStatus.CONFLICT;
        }else if(e instanceof PostReadException){
            status = HttpStatus.NOT_FOUND;
        }else if(e instanceof PostModifyException){
            status = HttpStatus.BAD_REQUEST;
        }else if(e instanceof PostWithdrawException){
            status = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(status).body(ApiResponseDTO.of(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiResponseDTO<Object>> ExceptionHandler(Exception e){
        log.info("Exception caught in CustomExceptionHandler");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponseDTO.of("잘못된 요청입니다."));
    }

}