package com.app.threetier.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDTO<T> {
    private String message;
    public T data;

    public static<T> ApiResponseDTO<T> of(String message){
        return new ApiResponseDTO<>(message, null);
    }

    public static<T> ApiResponseDTO<T> of(String message ,T data){
        return new ApiResponseDTO<>(message, data);
    }

}
