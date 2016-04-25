package com.practice.random;

/**
 * Created by abhi.pandey on 3/15/16.
 */
public class Employee {
    public String extension;
    public String fName;
    public String lName;

    public String getExtension() {
        return extension;
    }


    public String getfName() {
        return fName;
    }


    public String getlName() {
        return lName;
    }

    public Employee(String extension, String fName, String lName) {
        this.extension = extension;
        this.fName = fName;
        this.lName = lName;
    }
}
