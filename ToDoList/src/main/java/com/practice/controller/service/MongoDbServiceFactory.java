package com.practice.controller.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhi.pandey on 11/20/14.
 */
public class MongoDbServiceFactory {
    private static final Map<MongoDbInstanceId, MongoDBService> instanceById = new HashMap<MongoDbInstanceId, MongoDBService>();

    public static synchronized MongoDBService getService(String hostName, int port, String dbName) {
        MongoDbInstanceId instanceId = new MongoDbInstanceId(hostName, port, dbName);

        if(!instanceById.containsKey(instanceId)) {
            instanceById.put(instanceId,new MongoDBService(instanceId));
        }
        return instanceById.get(instanceId);
    }


}
