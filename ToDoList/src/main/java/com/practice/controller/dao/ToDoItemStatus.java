package com.practice.controller.dao;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by abhi.pandey on 9/28/14.
 */
@XmlRootElement
public class ToDoItemStatus extends ResponseObject {

    private int index;
    private String title;
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
