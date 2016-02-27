package com.practice.hadoop.hbase;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.Random;

/**
 * Created by abhi.pandey on 9/3/15.
 */
public class Importer1 {
    public static void main(String[] args) throws Exception {

        String[] pages = {"/", "/a.html", "/b.html", "/c.html"};

        String tableName = "access_logs";
        String[] families = {"details"};
        HBaseHelper.createTable(tableName, families);
        Table htable = HBaseHelper.getTable(tableName);

        htable.setWriteBufferSize(1024 * 1024 * 12);

        int totalRecords = 100000;
        int maxID = totalRecords / 1000;
        Random rand = new Random();
        System.out.println("importing " + totalRecords + " records ....");
        for (int i = 0; i < totalRecords; i++) {
            int userID = rand.nextInt(maxID) + 1;
            byte[] rowkey = Bytes.add(Bytes.toBytes(userID), Bytes.toBytes(i));
            String randomPage = pages[rand.nextInt(pages.length)];
            Put put = new Put(rowkey);
            put.add(Bytes.toBytes("details"), Bytes.toBytes("page"), Bytes.toBytes(randomPage));
            htable.put(put);
        }
        htable.close();

        System.out.println("done");
    }
}
