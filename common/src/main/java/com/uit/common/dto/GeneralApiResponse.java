package com.uit.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -6412669358869863966L;

    public static int STATUS_SUCCESS = 0;

    public static int STATUS_UNKNOWN_ERROR = 1;

    private String statusCode;
    private int status;
    private T result;

    public GeneralApiResponse(T result) { this("", STATUS_SUCCESS, result); }

    public static GeneralApiResponse<String> createErrorResponseWithCode(String errorCode) {
        return new GeneralApiResponse<String>(errorCode, STATUS_UNKNOWN_ERROR, "");
    }
    public static GeneralApiResponse<String> createErrorResponseWithCode(Enum<?> errorCode) {
        return createErrorResponseWithCode(errorCode.name());
    }

    public static <T> GeneralApiResponse<T> createSuccessResponse(T result){
        return new GeneralApiResponse<T>("OK", STATUS_SUCCESS, result);
    }
}
