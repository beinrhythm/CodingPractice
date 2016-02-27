package com.practice.hadoop.hbase;

/**
 * Created by abhi.pandey on 10/7/15.
 */

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.*;

public class HBaseTest {
    private static HBaseConfiguration conf;

    HBaseTest() {
        conf = new HBaseConfiguration();
        conf.addResource(new Path("/path_to_your_hbase/hbase-0.20.6/conf/hbase-site.xml"));
    }

// function to obtain distinct col entries from a table.

    public Set<String> distinct(String tableName, String colFamilyName, String colName) {
        Set<String> set = new HashSet<String>();
        ResultScanner rs = null;
        Result res = null;
        String s = null;
        try {
            HTable table = new HTable(conf, tableName);
            Scan scan = new Scan();
            scan.addColumn(Bytes.toBytes(colFamilyName), Bytes.toBytes(colName));
            rs = table.getScanner(scan);
            while ((res = rs.next()) != null) {
                byte[] obtCol = res.getValue(Bytes.toBytes(colFamilyName) ,Bytes.toBytes(colName));
                s = Bytes.toString(obtCol);
                set.add(s);
            }
        } catch (IOException e) {
            System.out.println("Exception occured in retrieving data");
        } finally {
            rs.close();
        }
        return set;
    }

// function to return distinct entries with the number of occurance of each.

    public HashMap<String, Integer> distinctWithOccurances(String tableName, String colFamilyName, String colName) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ResultScanner rs = null;
        Result res = null;
        try {
            HTable table = new HTable(conf, tableName);
            Scan scan = new Scan();
            rs = table.getScanner(scan);
            String s = null;
            while ((res = rs.next()) != null) {
                int noofOccurance = 0;
                int count = 0;
                byte[] obtCol = res.getValue(Bytes.toBytes(colFamilyName) ,Bytes.toBytes(colName));
                s = Bytes.toString(obtCol);
                Set<String> set = map.keySet();
                Iterator iterator = set.iterator();
                if (iterator != null) {
                    while (iterator.hasNext() && count == 0) {
                        String colEntry = (String) iterator.next();
                        if (colEntry.equals(s)) {
                            noofOccurance = map.get(colEntry);
                            int newNoofOccurance = noofOccurance + 1;
                            map.put(s, newNoofOccurance);
                            count++;
                        }
                    }
                }
                if (count == 0) {
                    map.put(s, 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception occured in retrieving data");
        } finally {
            rs.close();
        }
        return map;
    }

// function implementing having clause.

    public ArrayList<HashMap<String, String>> having(String tableName, String colFamilyName, String[] colName, String havingColName, String value) {
        ResultScanner rs = null;
        ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
        Result res = null;
        try {
            HTable table = new HTable(conf, tableName);
            Scan scan = new Scan();
            SingleColumnValueFilter singleColumnValueFilterA = new SingleColumnValueFilter(
                    Bytes.toBytes(colFamilyName), Bytes.toBytes(havingColName), CompareOp.EQUAL, Bytes.toBytes(value));
            singleColumnValueFilterA.setFilterIfMissing(true);
            FilterList filter = new FilterList(Operator.MUST_PASS_ALL, Arrays
                    .asList((Filter) singleColumnValueFilterA));
            scan.setFilter(filter);
            rs = table.getScanner(scan);
            while ((res = rs.next()) != null) {
                HashMap<String, String> map = new HashMap<String, String>();
                String s = null;
                for (int j = 0; j < colName.length; j++) {
                    byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName), Bytes.toBytes(colName[j]));
                    System.out.println(colName[j]);
                    s = Bytes.toString(obtainedRow);
                    map.put(colName[j], s);
                }
                al.add(map);
            }
        } catch (IOException e) {
            System.out.println("Exception occured in retrieving data");
        } finally {
            rs.close();
        }
        return al;
    }

// function implementing having clause and extracting the entire rows.

    public ArrayList<HashMap<String, String>> havingWithEntireRow(String tableName, String colFamilyName[], String[][] colName,
                                                                  String havingColFamilyName, String havingColName, String value) {
        ResultScanner rs = null;
        ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
        Result res = null;
        try {
            HTable table = new HTable(conf, tableName);
            Scan scan = new Scan();
            SingleColumnValueFilter singleColumnValueFilterA = new SingleColumnValueFilter(
                    Bytes.toBytes(havingColFamilyName), Bytes.toBytes(havingColName), CompareOp.EQUAL, Bytes.toBytes(value));
            singleColumnValueFilterA.setFilterIfMissing(true);
            FilterList filter = new FilterList(Operator.MUST_PASS_ALL, Arrays
                    .asList((Filter) singleColumnValueFilterA));
            scan.setFilter(filter);
            rs = table.getScanner(scan);
            while ((res = rs.next()) != null) {
                HashMap<String, String> map = new HashMap<String, String>();
                String s = null;
                for (int i = 0; i < colFamilyName.length; i++) {
                    for (int j = 0; j < colName[i].length; j++) {
                        byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName[i]), Bytes.toBytes(colName[i][j]));
                        s = Bytes.toString(obtainedRow);
                        map.put(colName[i][j], s);
                    }
                }
                al.add(map);
            }
        } catch (IOException e) {
            System.out.println("Exception occurred in retrieving data");
        } finally {
            rs.close();
        }
        return al;
    }

// function implementing the between clause.

    public ArrayList<HashMap<String, String>> between(String tableName, String colFamilyName, String[] colName, String betweenColName, String lowerValue, String upperValue) {
        ResultScanner rs = null;
        ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
        Result res = null;
        try {
            HTable table = new HTable(conf, tableName);
            Scan scan = new Scan();
            SingleColumnValueFilter singleColumnValueFilterA = new SingleColumnValueFilter(
                    Bytes.toBytes(colFamilyName), Bytes.toBytes(betweenColName), CompareOp.GREATER, Bytes.toBytes(lowerValue));
            singleColumnValueFilterA.setFilterIfMissing(true);
            SingleColumnValueFilter singleColumnValueFilterB = new SingleColumnValueFilter(
                    Bytes.toBytes(colFamilyName), Bytes.toBytes(betweenColName), CompareOp.LESS_OR_EQUAL, Bytes.toBytes(upperValue));
            singleColumnValueFilterB.setFilterIfMissing(true);
            FilterList filter = new FilterList(Operator.MUST_PASS_ALL, Arrays.asList((Filter) singleColumnValueFilterA,
                    singleColumnValueFilterB));
            scan.setFilter(filter);
            rs = table.getScanner(scan);
            while ((res = rs.next()) != null) {
                HashMap<String, String> map = new HashMap<String, String>();
                String s = null;
                for (int j = 0; j < colName.length; j++) {
                    byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName), Bytes.toBytes(colName[j]));
                    s = Bytes.toString(obtainedRow);
                    map.put(colName[j], s);
                }
                al.add(map);
            }
        } catch (IOException e) {
            System.out.println("Exception occurred in retrieving data");
        } finally {
            rs.close();
        }
        return al;
    }

// function implementing union.

    public ArrayList<HashMap<String, String>> union(String tableName, String colFamilyName1, String colFamilyName2, String[] colNames1, String[] colNames2, String colName1, String colName2, String value1, String value2) {
        ResultScanner rs = null;
        ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
        Result res = null;
        try {
            HTable table = new HTable(conf, tableName);
            Scan scan = new Scan();
            SingleColumnValueFilter singleColumnValueFilterA = new SingleColumnValueFilter(
                    Bytes.toBytes(colFamilyName1), Bytes.toBytes(colName1), CompareOp.EQUAL, Bytes.toBytes(value1));
            singleColumnValueFilterA.setFilterIfMissing(true);

            SingleColumnValueFilter singleColumnValueFilterB = new SingleColumnValueFilter(
                    Bytes.toBytes(colFamilyName2), Bytes.toBytes(colName2), CompareOp.EQUAL, Bytes.toBytes(value2));
            singleColumnValueFilterB.setFilterIfMissing(true);

            FilterList filter = new FilterList(Operator.MUST_PASS_ONE, Arrays.asList((Filter) singleColumnValueFilterA,
                    singleColumnValueFilterB));

            scan.setFilter(filter);
            rs = table.getScanner(scan);
            if (colFamilyName1.equals(colFamilyName2)) {
                while ((res = rs.next()) != null) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    String s = null;
                    for (int j = 0; j < colNames1.length; j++) {
                        byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName1), Bytes.toBytes(colNames1[j]));
                        System.out.println(colNames1[j]);
                        s = Bytes.toString(obtainedRow);
                        System.out.println(s);
                        map.put(colNames1[j], s);
                    }
                    al.add(map);
                }
            } else {
                while ((res = rs.next()) != null) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    String s = null;
                    // extract row of the first col family
                    for (int j = 0; j < colNames1.length; j++) {
                        byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName1), Bytes.toBytes(colNames1[j]));
                        s = Bytes.toString(obtainedRow);
                        map.put(colNames1[j], s);
                    }
                    // extract row of the second col family
                    for (int k = 0; k < colNames2.length; k++) {
                        byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName2), Bytes.toBytes(colNames2[k]));
                        s = Bytes.toString(obtainedRow);
                        map.put(colNames2[k], s);
                    }
                    // put both in the arraylist
                    al.add(map);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception occurred in retrieving data");
        } finally {
            rs.close();
        }
        return al;
    }

// function implementing intersection.

    public ArrayList<HashMap<String, String>> intersection(String tableName, String colFamilyName1, String colFamilyName2,
                                                           String[] colNames1, String[] colNames2, String colName1,
                                                           String colName2, String value1, String value2) {
        ResultScanner rs = null;
        ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
        Result res = null;
        try {
            HTable table = new HTable(conf, tableName);
            Scan scan = new Scan();
            SingleColumnValueFilter singleColumnValueFilterA = new SingleColumnValueFilter(
                    Bytes.toBytes(colFamilyName1), Bytes.toBytes(colName1), CompareOp.EQUAL, Bytes.toBytes(value1));
            singleColumnValueFilterA.setFilterIfMissing(true);
            SingleColumnValueFilter singleColumnValueFilterB = new SingleColumnValueFilter(
                    Bytes.toBytes(colFamilyName2), Bytes.toBytes(colName2), CompareOp.EQUAL, Bytes.toBytes(value2));
            singleColumnValueFilterB.setFilterIfMissing(true);

            FilterList filter = new FilterList(Operator.MUST_PASS_ALL, Arrays.asList((Filter) singleColumnValueFilterA,
                    singleColumnValueFilterB));
            scan.setFilter(filter);
            rs = table.getScanner(scan);
            if (colFamilyName1.equals(colFamilyName2)) {
                while ((res = rs.next()) != null) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    String s = null;
                    for (int j = 0; j < colNames1.length; j++) {
                        byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName1), Bytes.toBytes(colNames1[j]));
                        s = Bytes.toString(obtainedRow);
                        map.put(colNames1[j], s);
                    }
                    al.add(map);
                }
            } else {
                while ((res = rs.next()) != null) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    String s = null;
                    // extract row of the first col family
                    for (int j = 0; j < colNames1.length; j++) {
                        byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName1), Bytes.toBytes(colNames1[j]));
                        s = Bytes.toString(obtainedRow);
                        //System.out.println(s);
                        map.put(colNames1[j], s);
                    }
                    // extract row of the second col family
                    for (int k = 0; k < colNames2.length; k++) {
                        byte[] obtainedRow = res.getValue(Bytes.toBytes(colFamilyName2), Bytes.toBytes(colNames2[k]));
                        s = Bytes.toString(obtainedRow);
                        map.put(colNames2[k], s);
                    }
                    // put both in the arraylist
                    al.add(map);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception occurred in retrieving data");
        } finally {
            System.out.println("in intersection");
            rs.close();
        }
        return al;
    }

    public static void main(String args[]) {
        HBaseTest operationObj = new HBaseTest();
        String tableName = "testing_table";
        String[] colFamilyNames = {"colFamily1", "colFamily2"};
        String[][] colNames = {{"Id", "Name"}, {"Addr", "Designation"}};

        Set<String> set = operationObj.distinct(tableName, "colFamily1", "Name");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String valofKey = (String) iterator.next();
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map = operationObj.distinctWithOccurances(tableName, "Name", "Designation");

        ArrayList<HashMap<String, String>> al_having = new ArrayList<HashMap<String, String>>();
        al_having = operationObj.havingWithEntireRow(tableName, colFamilyNames, colNames, "colFamily1", "Name", "Jayati");

        String[] reqdFieldNames1 = {"Id", "Name"};
        String[] reqdFieldNames2 = {"Id", "Name"};
        ArrayList<HashMap<String, String>> al_intersection = new ArrayList<HashMap<String, String>>();
        al_intersection = operationObj.intersection(tableName, "colFamily1", "colFamily2", reqdFieldNames1, reqdFieldNames2, "Id", "Name", "1", "Jayati");

        // similarly union and between can be used
    }
}
