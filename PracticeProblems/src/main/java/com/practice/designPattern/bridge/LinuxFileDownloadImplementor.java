package com.practice.designPattern.bridge;

/**
 * Created by abhi.pandey on 10/16/15.
 */

/**
 * "ConcreteImplementor"  1/2
 */
public class LinuxFileDownloadImplementor implements FileDownloadImplementor {
    public Object downloadFile(String path) {
        System.out.println("Download file in linux");
        return null;
    }

    public boolean storeFile(Object object) {
        System.out.println("Storing file in linux");
        return false;
    }

    @Override
    public boolean delete(String object) {
        System.out.println("Deleting file in linux");
        return false;
    }
}
