package com.allen.demo.storage;

/**
 * Created by Allen on 2017/6/27.
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String messge) {
        super(messge);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
