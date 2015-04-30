package com.practice.controller.dao;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by abhi.pandey on 9/24/14.
 */
@XmlRootElement
public class User {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
