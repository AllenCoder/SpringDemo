package com.allen.demo.storage;

/**
 * Created by Allen on 2017/6/27.
 */
public class StorageException extends RuntimeException {
    public StorageException(String messge) {
        super(messge);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
