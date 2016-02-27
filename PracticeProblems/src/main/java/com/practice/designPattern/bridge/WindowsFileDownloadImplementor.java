package com.practice.designPattern.bridge;

/**
 * Created by abhi.pandey on 10/16/15.
 */

/**
 * "ConcreteImplementor"  1/2
 */
public class WindowsFileDownloadImplementor implements FileDownloadImplementor {
    public Object downloadFile(String path) {
        System.out.println("Download file in windows");
        return null;
    }

    public boolean storeFile(Object object) {
        System.out.println("Storing file in windows");
        return false;
    }

    @Override
    public boolean delete(String object) {
        System.out.println("Storing file in windows");
        return false;
    }
}
