package com.practice.controller.dao;

import com.practice.controller.service.MongoDBService;
import com.practice.controller.service.MongoDBServiceEnum;
import com.practice.controller.service.MongoDbServiceFactory;

import java.util.List;

/**
 * Created by abhi.pandey on 9/25/14.
 */
public enum ToDoItemsDao implements Dao<ToDoItems> {
    INSTANCE;


    private MongoDBService service;

    ToDoItemsDao(MongoDBService service) {
        this.service = service;
    }

    ToDoItemsDao() {

    }

    @Override
    public List<ResponseObject> get(String listId) {
        return MongoDBServiceEnum.INSTANCE.getAllItems(listId);
    }

    public List<ResponseObject> get(String listId, int index) {
        return MongoDBServiceEnum.INSTANCE.getIndexItem(listId, index);
    }


    @Override
    public ToDoItems getById(String id) {
        return null;
    }

    public boolean saveItems(ToDoItems toDoItem) {
        return MongoDBServiceEnum.INSTANCE.insert(toDoItem);
    }

    public boolean updateItem(ToDoItems toDoItem) {
        return MongoDBServiceEnum.INSTANCE.update(toDoItem);
    }

    public boolean deleteItem(ToDoItems toDoItem) {
        return MongoDBServiceEnum.INSTANCE.delete(toDoItem);
    }



   /* public static void main(String[] args) {
        String hostName = args[0];
        int port = Integer.valueOf(args[1]);
        String dbName= args[3];

        new ToDoItemsDao(MongoDbServiceFactory.getService(hostName, port, dbName));
    }*/
}
