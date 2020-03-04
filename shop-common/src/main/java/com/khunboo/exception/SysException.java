package com.khunboo.exception;


/**
 * 自定义异常
 */
public class SysException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public SysException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
