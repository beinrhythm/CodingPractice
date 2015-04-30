package com.practice.controller.service;

/**
* Created by abhi.pandey on 11/20/14.
*/
class MongoDbInstanceId {
    private final String dbName;
    private final String hostName;
    private final int port;

    public MongoDbInstanceId(String hostName, int port, String dbName) {
        //        validate(hostName, port, dbName); TODO
        this.hostName = hostName;
        this.port = port;
        this.dbName = dbName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MongoDbInstanceId that = (MongoDbInstanceId) o;

        if (port != that.port) return false;
        if (hostName != null ? !hostName.equals(that.hostName) : that.hostName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hostName != null ? hostName.hashCode() : 0;
        result = 31 * result + port;
        return result;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }
}
