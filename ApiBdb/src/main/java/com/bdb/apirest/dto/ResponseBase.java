package com.bdb.apirest.dto;

import lombok.Data;

@Data
public class ResponseBase {
    private boolean state;
    private String message;
    private Object data;
}
