package com.practice.controller.dao;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by abhi.pandey on 9/25/14.
 */

@XmlRootElement
public class ToDoItems extends ResponseObject {

    private int index;
    private String title;
    private String body;
    private boolean done;
    private String listId;

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
