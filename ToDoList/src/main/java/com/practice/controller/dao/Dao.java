package com.practice.controller.dao;

import java.util.List;

/**
 * Created by abhi.pandey on 9/21/14.
 */
public interface Dao<T> {

    List<ResponseObject> get(String listId);

    List<ResponseObject> get(String listId, int index);

    T getById(String id);

}
