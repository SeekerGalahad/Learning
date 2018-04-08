package kafka_learn;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.Locale;

public class WordCountProcessorDemo {
    public static void main(final String[] args) throws Exception {
//        final Properties props = new Properties();
//        props.put("application.id", "streams-wordcount-processor");
//        props.put("bootstrap.servers", "10.1.4.169:9092");
//        props.put("key.serde", Serdes.String().getClass());
//        props.put("value.serde", Serdes.String().getClass());
//        props.put("auto.offset.reset", "earliest");
//        final TopologyBuilder builder = new TopologyBuilder();
//        builder.addSource("Source", "streams-file-input");
//        builder.addProcessor("Process", new MyProcessorSupplier(), "Source");
//        builder.addStateStore(Stores.create("Counts").withStringKeys().withIntegerValues().inMemory().build(), "Process");
//        builder.addSink("Sink", "streams-wordcount-processor-output", "Process");
//        final KafkaStreams streams = new KafkaStreams(builder, props);
//        streams.start();
//        Thread.sleep(5000L);
//        streams.close();
    }

    private static class MyProcessorSupplier implements ProcessorSupplier<String, String> {
        public Processor<String, String> get() {
            return new Processor<String, String>() {
                private ProcessorContext context;
                private KeyValueStore<String, Integer> kvStore;

                public void init(final ProcessorContext context) {
                    (this.context = context).schedule(1000L);
                    this.kvStore = (KeyValueStore<String, Integer>) context.getStateStore("Counts");
                }

                public void process(final String dummy, final String line) {
                    final String[] words = line.toLowerCase(Locale.getDefault()).split(" ");
                    for (final String word : words) {
                        final Integer oldValue = this.kvStore.get(word);
                        if (oldValue == null) {
                            this.kvStore.put(word, 1);
                        } else {
                            this.kvStore.put(word, (oldValue + 1));
                        }
                    }
                    this.context.commit();
                }

                public void punctuate(final long timestamp) {
                    try (final KeyValueIterator<String, Integer> iter = this.kvStore.all()) {
                        System.out.println("----------- " + timestamp + " ----------- ");
                        while (iter.hasNext()) {
                            final KeyValue<String, Integer> entry = iter.next();
                            System.out.println("[" +  entry.key + ", " + entry.value + "]");
                            this.context.forward(entry.key,  entry.value.toString());
                        }
                    }
                }

                public void close() {
                    this.kvStore.close();
                }
            };
        }
    }
}
