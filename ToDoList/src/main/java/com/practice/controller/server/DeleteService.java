package com.practice.controller.server;

import com.practice.controller.dao.ResponseObject;
import com.practice.controller.dao.ToDoItemStatus;
import com.practice.controller.dao.ToDoItems;
import com.practice.controller.dao.ToDoItemsDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by abhi.pandey on 9/23/14.
 */
@Path("delete")
public class DeleteService {
    @DELETE
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON)

    public ResponseObject deleteTodo(ToDoItems todo) throws IOException {
        ToDoItemStatus status = new ToDoItemStatus();
        status.setTitle(todo.getTitle());
        status.setIndex(todo.getIndex());
        status.setDone(null);

        if(ToDoItemsDao.INSTANCE.deleteItem(todo)){

            status.setMessage("Success to delete");
        }
        else{
            status.setMessage("Failed to delete");
        }
        return status;
    }
}
