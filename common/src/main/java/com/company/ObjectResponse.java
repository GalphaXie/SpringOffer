package com.company;


import com.company.constant.ResponseCode;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ObjectResponse<T> {
    @Builder.Default
    private ResponseCode responseCode = ResponseCode.SUCCESS;
    private T data;
    @Builder.Default
    private String errorMsg = "";

}
