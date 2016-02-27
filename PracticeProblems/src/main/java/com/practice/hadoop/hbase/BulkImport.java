package com.practice.hadoop.hbase;

/**
 * Created by abhi.pandey on 9/15/15.
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapred.lib.NullOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

public class BulkImport implements Tool {
    private static final String NAME = "BulkImport";
    private Configuration conf;

    public static class InnerMap extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
        private HTable table;
        private HBaseConfiguration HBconf;

        public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            if ( table == null )
                throw new IOException("table is null");

            String [] splits = value.toString().split("\t");
            if ( splits.length != 4 )
                return;

            String rowID     = splits[0];
            int timestamp    = Integer.parseInt( splits[1] );
            String colID     = splits[2];
            String cellValue = splits[3];

            reporter.setStatus("Map emitting cell for row='" + rowID + "', column='" + colID + "', time='" + timestamp + "'");

            Put p = new Put(cellValue.getBytes());

            p.addColumn(Bytes.toBytes("c1"), Bytes.toBytes("c1"),
                    Bytes.toBytes("Through Hadoop"));

            table.put(p);
        }

        public void configure(JobConf job) {
            HBconf = new HBaseConfiguration();
            try {
                table = new HTable( HBconf, job.get("input.table") );
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public JobConf createSubmittableJob(String[] args) {
        JobConf c = new JobConf(getConf(), BulkImport.class);
        c.setJobName(NAME);
        c.set("input.table", args[1]);
        c.setMapperClass(InnerMap.class);
        c.setNumReduceTasks(0);
        c.setOutputFormat(NullOutputFormat.class);
        return c;
    }

    static int printUsage() {
        System.err.println("Usage: " + NAME + " <input> <table_name>");
        System.err.println("\twhere <input> is a tab-delimited text file with 4 columns.");
        System.err.println("\t\tcolumn 1 = row ID");
        System.err.println("\t\tcolumn 2 = timestamp (use a negative value for current time)");
        System.err.println("\t\tcolumn 3 = column ID");
        System.err.println("\t\tcolumn 4 = cell value");
        return -1;
    }

    public int run(@SuppressWarnings("unused") String[] args) throws Exception {
        // Make sure there are exactly 3 parameters left.
        if (args.length != 2) {
            return printUsage();
        }
        JobClient.runJob(createSubmittableJob(args));
        return 0;
    }

    public Configuration getConf() {
        return this.conf;
    }

    public void setConf(final Configuration c) {
        this.conf = c;
    }

    public static void main(String[] args) throws Exception {
        int errCode = ToolRunner.run(new Configuration(), new BulkImport(), args);
        System.exit(errCode);
    }
}
