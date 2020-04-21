package com.khunboo.constant;

public enum ErrorCode {

    ACCOUNTERROR(201, "账号或者密码错误"),
    RUNERROR(301, "运行出错啦"),
    NULLPOINT(302, "空指针异常");

    int code;

    String msg;

    ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }


    public static String getValue(Integer code){
        if(code == null){
            return "";
        } else {
            for (ErrorCode s: ErrorCode.values()){
                if(s.getCode() == code){
                    return s.getMsg();
                }
            }
        }

        return "";
    }
}
