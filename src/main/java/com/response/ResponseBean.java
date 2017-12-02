package com.response;

import netscape.javascript.JSObject;

import java.util.List;

public class ResponseBean
{


    private Integer code;

    private String message;

    private List<?> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}