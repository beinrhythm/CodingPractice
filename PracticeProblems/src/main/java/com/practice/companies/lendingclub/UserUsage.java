package com.practice.companies.lendingclub;

/**
 * Created by abhi.pandey on 5/10/16.
 */
public class UserUsage {
    int processID;
    String username;
    int cpuUsage;
    double startTime;
    double endTime;

    public UserUsage(int processID, String username, int cpuUsage, double startTime, double endTime) {
        this.processID = processID;
        this.username = username;
        this.cpuUsage = cpuUsage;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
