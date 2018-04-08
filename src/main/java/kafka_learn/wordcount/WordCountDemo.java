package kafka_learn.wordcount;

public class WordCountDemo {

    public static void main(final String[] args) throws Exception {
//
//        final Properties props = new Properties();
//        (props).put("application.id", "streams-wordcount");
//        (props).put("bootstrap.servers", "10.1.4.169:9092");
//        (props).put("key.serde", Serdes.String().getClass().getName());
//        (props).put("value.serde", Serdes.String().getClass().getName());
//        (props).put("auto.offset.reset", "earliest");
//
//        final KStreamBuilder builder = new KStreamBuilder();
//
//        final KStream<String, String> source = builder.stream(new String[]{"streams-plaintext-input"});
//
//        final KTable<String, Long> counts =
//                source.flatMapValues(value -> Arrays.asList(value.toLowerCase(Locale.getDefault()).split(" ")))
//                        .map((KeyValueMapper<String, String, KeyValue<String, String>>) (key, value) ->
//                                new KeyValue(value, value)).groupByKey().count("Counts");
//
//        counts.to(Serdes.String(), Serdes.Long(), "streams-wordcount-output");
//
//        final KafkaStreams streams = new KafkaStreams(builder, props);
//        streams.start();
//        Thread.sleep(5000L);
//        streams.close();
    }
}
