package com.practice.controller.server;

import com.practice.controller.dao.ResponseObject;
import com.practice.controller.dao.ToDoItemStatus;
import com.practice.controller.dao.ToDoItemsDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by abhi.pandey on 9/25/14.
 */
@Path("get")
public class GetService {

    @GET
    @Path("{listId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResponseObject> getItemInJSON(
            @PathParam("listId") String listId,
            @DefaultValue("0") @QueryParam("index") int index
    ) {
        if (index > 0) {
            List<ResponseObject> ro = ToDoItemsDao.INSTANCE.get(listId, index);
            if (!ro.isEmpty()) {
                return ro;
            }else{
                ToDoItemStatus td = new ToDoItemStatus();
                td.setMessage("No such item");
                td.setIndex(index);
                td.setTitle("Error");
                td.setDone(null);
                ro.add(td);
                return ro;
            }
        }

          return ToDoItemsDao.INSTANCE.get(listId);



    }
}
