package com.practice.designPattern.bridge;

/**
 * Created by abhi.pandey on 10/16/15.
 */

/**
 * "Refined Abstraction"
 */
public class FileDownloaderAbstractionImpl extends FileDownloaderAbstraction {

    public FileDownloaderAbstractionImpl(FileDownloadImplementor driver) {
        super(driver);

    }

    public Object download(String path) {
        return driver.downloadFile(path);
    }

    public boolean store(Object object) {
        return driver.storeFile(object);
    }

    @Override
    public boolean delete(String object) {
        return driver.delete(object);
    }
}
