package com.practice.designPattern.bridge;

/**
 * Created by abhi.pandey on 10/16/15.
 */
public class DownloadClient {
    public static void main(String[] args) {

        String os = "windows";

        FileDownloaderAbstraction downloader = null;

        switch (os) {
            case "windows":
                downloader = new FileDownloaderAbstractionImpl(new WindowsFileDownloadImplementor());
                break;

            case "linux":
                downloader = new FileDownloaderAbstractionImpl(new LinuxFileDownloadImplementor());
                break;

            default:
                System.out.println("OS not supported !!");
        }
        Object fileContent = downloader.download("some path");
        downloader.store(fileContent);

    }
}
