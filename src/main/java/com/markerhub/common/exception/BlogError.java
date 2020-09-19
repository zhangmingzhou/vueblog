package com.markerhub.common.exception;

public enum BlogError {

    UserNotFound("用户没找到",400)
    ;
    private String message;
    private long code;

    BlogError(String message,long code){
        this.code = code;
        this.message = message;
    }


    public String getMessage(){
        return message;
    }

    public long getCode(){
        return code;
    }
}
