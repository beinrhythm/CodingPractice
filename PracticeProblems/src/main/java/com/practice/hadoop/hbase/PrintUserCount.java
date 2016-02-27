package com.practice.hadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by abhi.pandey on 9/13/15.
 */
public class PrintUserCount {
    public static void main(String[] args) throws Exception {

        Configuration conf = HBaseConfiguration.create();
        Connection cn = ConnectionFactory.createConnection(conf);
        TableName tableName = TableName.valueOf("summary_user");
        Table table = cn.getTable(tableName);

        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        Result r;
        while (((r = scanner.next()) != null)) {
            byte[] key = r.getRow();
            int userId = Bytes.toInt(key);
            byte[] totalValue = r.getValue(Bytes.toBytes("details"), Bytes.toBytes("total"));
            int count = Bytes.toInt(totalValue);

            System.out.println("key: " + userId + ",  count: " + count);
        }
        scanner.close();
        table.close();
        cn.close();
    }
}
