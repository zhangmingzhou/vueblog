package com.markerhub.common.exception;

public enum BlogError {

    BlogNotFound("博客未找到",400),
    BlogWithoutTitle("标题不能为空",400),
    BlogWithoutContent("输入空内容",400),
    BlogWithoutUserId("无用户ID",400),
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
