package com.khunboo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    public static final long serialVersionUID = 1L;

    public Result(){

    }

    public Result(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result success(){

        return new Result(200, null, null);
    }

    public Result error(){
        return new Result(500, "服务器异常", null);
    }

    private int code;
    private String msg;
    private Object data;
}
