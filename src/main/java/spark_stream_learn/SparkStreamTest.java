package spark_stream_learn;

public class SparkStreamTest {

    public static void main(String[] args) {
//        // Create a local StreamingContext with two working thread and batch interval of 1 second
//        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
//        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
//
//        // Create a DStream that will connect to hostname:port, like localhost:9999
//        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);
//        // Split each line into words
//        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
//
//        // Count each word in each batch
//        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s, 1));
//        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((i1, i2) -> i1 + i2);
//
//        // Print the first ten elements of each RDD generated in this DStream to the console
//        wordCounts.print();
    }
}