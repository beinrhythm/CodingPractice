package com.practice.controller.service;

import com.google.common.collect.Lists;
import com.mongodb.*;
import com.practice.controller.dao.ResponseObject;
import com.practice.controller.dao.ToDoItems;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.MongoClient;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by abhi.pandey on 9/25/14.
 */
public enum MongoDBServiceEnum {

    INSTANCE;
    private static final String DBName = "ToDoList";
    private final int port = 27017;
    private final String hostName = "localhost";
    private DB db;
    private DBCollection table;

    private void setCollectionName(String listName) {
        table = db.getCollection(listName);
    }

    private MongoDBServiceEnum() {
        try {
            Mongo mongo = new MongoClient(this.hostName, this.port);
            db = mongo.getDB(DBName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
   /* public MongoDBServiceEnum getInstance(final String hostName, final int port){
        if(instance == null) {
            instance = new MongoDBServiceEnum(hostName,port);
        }
        return this.instance;
    }

    public static void Instantiate(){

    }*/

    // create a document to store key and value
    public boolean insert(ToDoItems toDoItem) {
        boolean status = true;
        try {
            if (find(toDoItem)) {
                update(toDoItem);
            } else {
                setCollectionName(toDoItem.getListId());
                BasicDBObject document = new BasicDBObject();
                document.put("index", toDoItem.getIndex());
                document.put("title", toDoItem.getTitle());
                document.put("body", toDoItem.getBody());
                document.put("done", toDoItem.isDone());
                document.put("listId", toDoItem.getListId());
                table.insert(document);
            }


        } catch (MongoException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public List<ResponseObject>  getIndexItem(String listId, int index) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("index", index);
        setCollectionName(listId);
        DBCursor cursor = table.find(searchQuery);
        List<ResponseObject> allItems = Lists.newArrayList();
        ToDoItems item;
        try {

            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String bsonString = obj.toString();
                JSONObject newObject = new JSONObject(bsonString);
                if (newObject.get("index").equals(index)) {
                    item =  new ToDoItems();
                    item.setTitle(newObject.get("title").toString());
                    item.setBody(newObject.get("body").toString());
                    item.setDone((Boolean) newObject.get("done"));
                    item.setListId((String) newObject.get("listId"));
                    item.setIndex((Integer) newObject.get("index"));
                    allItems.add(item);
                }
            }


        } catch (MongoException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException("Failed to convert JSON String document into a JSON Object.", e);

        } finally {
            cursor.close();
        }

        if(allItems.isEmpty()){

        }
        return allItems;
    }

    public boolean find(ToDoItems toDoItem) {
        boolean status = true;
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("index", toDoItem.getIndex());
        setCollectionName(toDoItem.getListId());
        DBCursor cursor = table.find(searchQuery);
        try {
            if (!cursor.hasNext()) {
                status = false;
            }

        } catch (MongoException e) {
            e.printStackTrace();
            status = false;
        } finally {
            cursor.close();
        }

        return status;
    }

    public List<ResponseObject> getAllItems(String listId) {
        setCollectionName(listId);
        DBCursor cursor = table.find();
        List<ResponseObject> allItems = Lists.newArrayList();
        try {
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                ToDoItems item = new ToDoItems();
                String bsonString = obj.toString();
                JSONObject newObject = new JSONObject(bsonString);

                item.setTitle(newObject.get("title").toString());
                item.setBody(newObject.get("body").toString());
                item.setDone((Boolean) newObject.get("done"));
                item.setListId((String) newObject.get("listId"));
                item.setIndex((Integer) newObject.get("index"));
                allItems.add(item);

            }
        } catch (MongoException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException("Failed to convert JSON String document into a JSON Object.", e);
        } finally {
            cursor.close();
        }

        return allItems;
    }

    public boolean update(ToDoItems toDoItem) {

        boolean status = true;
        try {
            setCollectionName(toDoItem.getListId());
            BasicDBObject query = new BasicDBObject();
            query.put("index", toDoItem.getIndex());

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("title", toDoItem.getTitle());
            newDocument.put("body", toDoItem.getBody());
            newDocument.put("done", toDoItem.isDone());

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            table.update(query, updateObj);
        } catch (MongoException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public boolean delete(ToDoItems toDoItem) {
        boolean status = true;
        try {
            setCollectionName(toDoItem.getListId());
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("index", toDoItem.getIndex());

            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }


}
