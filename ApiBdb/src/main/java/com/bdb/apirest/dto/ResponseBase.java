package com.bdb.apirest.dto;

import lombok.Data;

@Data
public class ResponseBase {
    private boolean state;
    private String message;
    private Object data;

    public ResponseBase() {
    }

    public ResponseBase(boolean state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
    
    
}
