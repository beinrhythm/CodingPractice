package com.practice.hadoop.hbase;

/**
 * Created by abhi.pandey on 9/18/15.
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Import {

    final static String NAME = "HbaseImport";
    public static final String hdfsHostname = "localhost";
    public static final String hdfsPort = "9000";
    public static final String hBaseTableName = "proactive_splunk_result";
    public static final String inputDirectoryName = "splunk";
    private static String dfsWorkDirectory;

    static class Importer extends TableMapper<ImmutableBytesWritable, Put> {

        @Override
        public void map(ImmutableBytesWritable row, Result value, Context context) throws IOException {

            try {
                context.write(row, resultToPut(row, value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static Put resultToPut(ImmutableBytesWritable key, Result result) throws IOException {
            Put put = new Put(key.get());
            for (KeyValue kv : result.raw()) {
                put.add(kv);
            }
            return put;
        }
    }

    public static Job createSubmittableJob(Configuration conf) throws Exception {

        List<Path> filesToProcess = convertAndLoadData();
        Job job = Job.getInstance(conf, NAME + "" + hBaseTableName);
        job.setJarByClass(Importer.class);
        FileInputFormat.setInputPaths(job, filesToProcess.toArray(new Path[filesToProcess.size()]));
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setMapperClass(Importer.class);

        TableMapReduceUtil.initTableReducerJob(hBaseTableName, null, job);
        job.setNumReduceTasks(0);
        return job;
    }

    private static List<Path> convertAndLoadData() throws Exception {
        final DistributedFileSystem dfs = new DistributedFileSystem();
        dfs.initialize(new URI("hdfs://" + hdfsHostname + ":" + hdfsPort + "/"),
                new Configuration());
        dfsWorkDirectory = dfs.getWorkingDirectory().toString();
        System.out.println("dfs work dir: " + dfsWorkDirectory);
        dfs.close();
        final List<Path> filesToProcess = getFilesToProcess(inputDirectoryName);
        System.out.println("processing files: " + filesToProcess);
        return filesToProcess;
    }

    private static List<Path> getFilesToProcess(String monthDirPath) throws Exception {

        List<Path> rv = new ArrayList<Path>();
        final FileSystem fileSystem = FileSystem
                .get(new URI("hdfs://" + hdfsHostname + ":" + hdfsPort + "/"),
                        new Configuration());
        for (final FileStatus fileStatus : fileSystem.listStatus(new Path(monthDirPath))) {
            rv.add(fileStatus.getPath());
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Starting map reduce job to convert data to hbase format");
        long startTime = System.currentTimeMillis();

        Configuration conf = HBaseConfiguration.create();

        Job job = createSubmittableJob(conf);
        job.waitForCompletion(true);
        System.out.println("Finished map reduce job to convert data to hbase format for " + hBaseTableName + "time " +
                "taken: " + (System.currentTimeMillis() - startTime));
    }
}