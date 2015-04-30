package com.practice.controller.server;

import com.practice.controller.dao.ResponseObject;
import com.practice.controller.dao.ToDoItemStatus;
import com.practice.controller.dao.ToDoItems;
import com.practice.controller.dao.ToDoItemsDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by abhi.pandey on 9/23/14.
 */
@Path("save")
public class SaveService {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public ResponseObject newTodo(ToDoItems todo) throws IOException {
        ToDoItemStatus status = new ToDoItemStatus();
        status.setTitle(todo.getTitle());
        status.setIndex(todo.getIndex());
        status.setDone(null);
        if (ToDoItemsDao.INSTANCE.saveItems(todo)) {

            status.setMessage("Success to insert");
        } else {
            status.setMessage("Failed to insert");
        }
        return status;
    }

}
