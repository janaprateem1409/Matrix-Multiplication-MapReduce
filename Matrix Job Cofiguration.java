package matrix;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextOutputFormat;
public class MatrixMultiplication{

        public static void main(String args[]) throws Exception{
                Configuration conf = new Configuration();
                conf.set("m","2");
                conf.set("n","5");
                conf.set("p","3");
                Job job = new Job(conf,"MatrixMultiplication");
                job.setJarByClass(MatrixMultiplication.class);
                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(Text.class);
                job.setMapperClass(MatrixMapper.class);
                job.setReducerClass(MatrixReducer.class);
                job.setInputFormatClass(TextInputFormat.class);
                job.setOutputFormatClass(TextOutputFormat.class);
                FileInputFormat.addInputPath(job, new Path(args[0]));
                FileOutputFormat.addOutputPath(job, new Path(args[1]));
                job.waitForCompletion(true);




        }
}
