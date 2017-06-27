package com.allen.demo.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Allen on 2017/6/27.
 */
@ConfigurationProperties("storge")
public class StorageProperties {

    private String location ="upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
