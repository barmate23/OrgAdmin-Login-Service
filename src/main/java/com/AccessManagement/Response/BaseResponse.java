package com.AccessManagement.Response;

import lombok.Data;

import java.util.List;

@Data
public class BaseResponse <T>{
    private Integer status;
    private String message;
    private List<T> data;
    private Integer  code;
    private String logId;

}
