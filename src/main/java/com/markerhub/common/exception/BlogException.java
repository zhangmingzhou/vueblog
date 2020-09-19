package com.markerhub.common.exception;

public class BlogException extends RuntimeException {

    public BlogException(String message, Throwable error){
        super(message,error);
    }

    public BlogException(BlogError blogError, Throwable throwable){
        super(blogError.getMessage(),throwable);
    }

    public BlogException(BlogError blogError){
        super(blogError.getMessage());
    }

    public BlogException(String message){
        super(message);
    }
}
