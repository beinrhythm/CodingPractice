package com.practice.controller.dao;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by abhi.pandey on 10/14/14.
 */
@XmlRootElement
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ResponseObject {

    private int index;
    private String title;
    private String body;
    private Boolean done;
    private String listId;
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getListId() {return listId; }

    public void setListId(String listId) {this.listId = listId;}

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
