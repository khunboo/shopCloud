package com.khunboo.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 响应状态：200表示成功；500表示失败
     */
    private int code = 200;

    /**
     * 响应消息
     */
    private String msg = "success";

    /**
     * 响应数据
     */
    private T data;


    public Result<T> success(){

        return this;
    }

    public Result<T> success(T data){
        this.setData(data);
        return this;
    }

    public Result<T> error(){
        this.setCode(500);
        return this;
    }

    public Result<T> error(int code, String msg){
        this.setCode(code);
        this.setMsg(msg);

        return this;
    }

    public Result<T> success(int code, String msg){
        this.setCode(code);
        this.setMsg(msg);

        return this;
    }
}
