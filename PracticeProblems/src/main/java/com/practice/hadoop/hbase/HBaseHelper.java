package com.practice.hadoop.hbase;

import com.google.common.base.Strings;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhi.pandey on 8/21/15.
 */

public class HBaseHelper {

    private static Configuration conf = null;

    /*
     * Create a table
     */
    public static void createTable(String name, String[] familys)
            throws Exception {
        Connection cn = ConnectionFactory.createConnection(conf);
        try {
            TableName tableName = TableName.valueOf(name);
            Admin admin = cn.getAdmin();
            if (admin.tableExists(tableName)) {
                System.out.println("table already exists!");
            } else {
                HTableDescriptor tableDesc = new HTableDescriptor(tableName);
                for (int i = 0; i < familys.length; i++) {
                    tableDesc.addFamily(new HColumnDescriptor(familys[i]));
                }
                admin.createTable(tableDesc);
                System.out.println("create table " + tableName + " ok.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
    }

    /**
     * Delete a table
     */
    public static void deleteTable(TableName tableName) throws Exception {
        Connection cn = ConnectionFactory.createConnection(conf);
        try {
            Admin admin = cn.getAdmin();
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
            System.out.println("delete table " + tableName + " ok.");
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
    }

    /**
     * Put (or insert) a row
     */
    public static void addRecord(TableName tableName, String rowKey,
                                 String family, String qualifier, String value) throws IOException {
        Connection cn = ConnectionFactory.createConnection(conf);
        try {
            Table table = cn.getTable(tableName);
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes
                    .toBytes(value));
            table.put(put);
            System.out.println("insert recorded " + rowKey + " to table "
                    + tableName + " ok.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
    }

    /**
     * Delete a row
     */
    public static void delRecord(TableName tableName, String rowKey)
            throws IOException {
        Connection cn = ConnectionFactory.createConnection(conf);
        try {
            Table table = cn.getTable(tableName);
            List<Delete> list = new ArrayList<Delete>();
            Delete del = new Delete(rowKey.getBytes());
            list.add(del);
            table.delete(list);
            System.out.println("del recored " + rowKey + " ok.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
    }

    /**
     * Get a row
     */
    public static void getOneRecord(TableName tableName, String rowKey) throws IOException {
        Connection cn = ConnectionFactory.createConnection(conf);
        try {
            Table table = cn.getTable(tableName);
            Get get = new Get(rowKey.getBytes());
            Result rs = table.get(get);
            for (Cell cell : rs.rawCells()) {
                System.out.print(CellUtil.getCellKeyAsString(cell) + " ");
                System.out.print(Arrays.toString(CellUtil.cloneFamily(cell)) + ":");
                System.out.print(Arrays.toString(CellUtil.cloneQualifier(cell)) + " ");
                System.out.print(cell.getTimestamp() + " ");
                System.out.println(new String(CellUtil.cloneValue(cell)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
    }

    /**
     * Scan (or list) a table
     */
    public static void getAllRecord(TableName tableName) throws IOException {
        Connection cn = ConnectionFactory.createConnection(conf);
        try {
            Table table = cn.getTable(tableName);
            Scan s = new Scan();
            ResultScanner ss = table.getScanner(s);
            for (Result r : ss) {
                for (KeyValue kv : r.raw()) {
                    System.out.print(new String(kv.getRow()) + " ");
                    System.out.print(new String(kv.getFamily()) + ":");
                    System.out.print(new String(kv.getQualifier()) + " ");
                    System.out.print(kv.getTimestamp() + " ");
                    System.out.println(new String(kv.getValue()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
    }

    public static List<String> getAllRecordForAnAccount(TableName tableName, String accountName,
                                                        long startTime, long endTime) throws IOException {

        if (tableName == null) {
            System.out.println("Table name can't be null");
            return Collections.emptyList();
        }
        if(Strings.isNullOrEmpty(accountName)){
            System.out.println("Account name can't be null/empty");
            return Collections.emptyList();
        }
        if(startTime >= endTime){
            System.out.println("Start time must be lesser than End time");
            return Collections.emptyList();
        }
        Connection cn = ConnectionFactory.createConnection(conf);
        ArrayList<String> listOfFeatures = new ArrayList<String>();
        try {
            Table table = cn.getTable(tableName);
            Scan scan = new Scan();
            scan.addColumn(Bytes.toBytes("info"), Bytes.toBytes("feature"));
            String startRow = accountName + "#" + startTime;
            scan.setStartRow(startRow.getBytes());
            String stopRow = accountName + "#" + endTime;
            scan.setStopRow(stopRow.getBytes());

            ResultScanner scanner = table.getScanner(scan);
            for (Result res : scanner) {
                String key = Bytes.toString(res.getRow());

                System.out.print(key + " ");
                for (Cell cell : res.rawCells()) {
                    String feature = new String(CellUtil.cloneValue(cell));
                    System.out.println(feature);
                    listOfFeatures.add(feature);
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
        return listOfFeatures;
    }

    public static Table getTable(String name) throws IOException {
        Connection cn = ConnectionFactory.createConnection(conf);
        Table table = null;
        try {
            TableName tableName = TableName.valueOf(name);
            table = cn.getTable(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cn != null)
                cn.close();
        }
        return table;
    }

    public static void main(String[] agrs) {
        try {
            conf = HBaseConfiguration.create();
            conf.clear();
            conf.set("hbase.master", "10.0.33.182:60010");
            conf.set("hbase.zookeeper.quorum", "10.0.33.182");
            conf.set("hbase.zookeeper.property.clientPort", "2181");
            HBaseAdmin.checkHBaseAvailable(conf);
            System.out.println("connected to remote hbase");

            String name = "proactive_splunk_result";

            TableName tableName = TableName.valueOf(name);

            List<String> listOfFeatures = HBaseHelper.getAllRecordForAnAccount(tableName, "wizards", 1420099200000L, 1420099265000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}