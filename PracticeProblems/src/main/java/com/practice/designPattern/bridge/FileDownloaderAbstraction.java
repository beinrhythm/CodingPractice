package com.practice.designPattern.bridge;

/**
 * Created by abhi.pandey on 10/16/15.
 */

/**
 * "Abstraction"
 */
public abstract class FileDownloaderAbstraction {

    public abstract Object download(String path);

    public abstract boolean store(Object object);

    public abstract boolean delete(String object);

    FileDownloadImplementor driver = null;

    public FileDownloaderAbstraction(FileDownloadImplementor driver) {
        this.driver = driver;
    }

}
