package com.khunboo.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    public static final long serialVersionUID = 1L;

    public Result(){

    }

    public Result(String code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private String code;
    private String msg;
    private Object data;
}
