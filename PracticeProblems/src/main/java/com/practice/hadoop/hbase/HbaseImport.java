package com.practice.hadoop.hbase;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.HFileOutputFormat2;
import org.apache.hadoop.hbase.mapreduce.LoadIncrementalHFiles;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRConfig;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by abhi.pandey on 9/14/15.
 */
public class HbaseImport {

    public static final String hdfsHostname = "localhost";
    public static final String hdfsPort = "9000";
    public static final String hBaseTableName = "proactive_splunk_result";

    public static final String inputDirectoryName = "splunk";
    public static final String outputDirectoryName = "splunk_results";

    private String dfsWorkDirectory;
    private static final String NAME = "HbaseImport";
    private Configuration conf;

    public static void main(String[] args) {
        new HbaseImport().startImport();
    }

    public void startImport() {
        try {
            final long startTime = System.currentTimeMillis();
            final DistributedFileSystem dfs = new DistributedFileSystem();
            dfs.initialize(new URI("hdfs://" + hdfsHostname + ":" + hdfsPort + "/"),
                    new Configuration());
            dfsWorkDirectory = dfs.getWorkingDirectory().toString();
            System.out.println("dfs work dir: " + dfsWorkDirectory);
            dfs.close();
            convertAndLoadData();
            System.out.println("time taken to migrate " + ": " + (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void convertAndLoadData() throws Exception {

        System.out.println("Starting map reduce job to convert data to hbase format");
        long startTime = System.currentTimeMillis();
        conf = HBaseConfiguration.create();
        System.out.println(MRConfig.FRAMEWORK_NAME + " " + conf.get(MRConfig.FRAMEWORK_NAME));
        final Job job = Job.getInstance(conf, "migration");
        job.setJobName(NAME);
        configureJob(job);


        final HTable hTable = new HTable(conf, hBaseTableName);

        HFileOutputFormat2.configureIncrementalLoad(job, hTable);
        final List<Path> filesToProcess = getFilesToProcess(inputDirectoryName);
        System.out.println("processing files: " + filesToProcess);
        FileInputFormat.setInputPaths(job, filesToProcess.toArray(new Path[filesToProcess.size()]));

        HFileOutputFormat2.setOutputPath(job,
                new Path(dfsWorkDirectory + File.separator + outputDirectoryName
                        + File.separator + hBaseTableName));

        job.waitForCompletion(true);
        System.out.println("Finished map reduce job to convert data to hbase format for " + hBaseTableName + "time " +
                "taken: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("bulk load started");
        final Configuration config = job.getConfiguration();
        HBaseConfiguration.addHbaseResources(config);
        final LoadIncrementalHFiles loadFiles =
                new LoadIncrementalHFiles(conf);
        loadFiles.setConf(config);
        loadFiles.doBulkLoad(new Path(dfsWorkDirectory + File.separator
                + outputDirectoryName + File.separator + hBaseTableName), hTable);
        System.out.println("bulk load finished . Time taken: " + (System.currentTimeMillis() - startTime));
    }

    private List<Path> getFilesToProcess(String monthDirPath) throws Exception {

        List<Path> rv = new ArrayList<Path>();
        final FileSystem fileSystem = FileSystem
                .get(new URI("hdfs://" + hdfsHostname + ":" + hdfsPort + "/"),
                        new Configuration());
        for (final FileStatus fileStatus : fileSystem.listStatus(new Path(monthDirPath))) {
            rv.add(fileStatus.getPath());
        }

        return rv;
    }

    private void configureJob(final Job job) throws IOException {
        job.setJarByClass(HbaseMigrationMapper.class);
        job.setMapperClass(HbaseMigrationMapper.class);
        job.setMapOutputKeyClass(ImmutableBytesWritable.class);
        job.setMapOutputValueClass(KeyValue.class);
        job.setNumReduceTasks(0);
        TableMapReduceUtil.initTableReducerJob(hBaseTableName, null, job);
    }

    public static class HbaseMigrationMapper extends Mapper<LongWritable, Text, ImmutableBytesWritable, KeyValue> {

        private static final int TIMESTAMP_INDEX = 0;
        private static final int FEATURE_INDEX = TIMESTAMP_INDEX + 1;
        private static final int ACCOUNT_NAME_INDEX = FEATURE_INDEX + 1;
        public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private long timestamp;
        private String accountName;
        private String feature;

        @Override
        public void map(LongWritable row, final Text value, Context context) throws IOException {
            try {
                final String[] values = StringUtils.split(value.toString(), ",");
                String dateTime = (values[TIMESTAMP_INDEX]).replace("\"", "");
                Date date = formatter.parse(dateTime);
                timestamp = date.getTime();
                accountName = String.valueOf(values[ACCOUNT_NAME_INDEX]).replace("\"", "");
                feature = String.valueOf(values[FEATURE_INDEX]).replace("\"", "");
                String hkey = accountName + "#" + timestamp;
                ImmutableBytesWritable hbaseTableKey = new ImmutableBytesWritable(hkey.getBytes());


                context.write(hbaseTableKey, new KeyValue(hbaseTableKey.get(), Bytes.toBytes("info"),
                        Bytes.toBytes("account"), Bytes.toBytes(accountName)));

                context.write(hbaseTableKey, new KeyValue(hbaseTableKey.get(), Bytes.toBytes("info"),
                        Bytes.toBytes("feature"), Bytes.toBytes(feature)));

                context.write(hbaseTableKey, new KeyValue(hbaseTableKey.get(), Bytes.toBytes("info"),
                        Bytes.toBytes("datetime"), Bytes.toBytes(dateTime)));

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
