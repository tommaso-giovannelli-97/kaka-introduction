package io.conduktor.demos.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class);


    public static void main(String[] args) {
        log.info("I am a Kafka Producer!");

        final String TOPIC_NAME = "demo_kafka_topic";

        // create Producer Properties
        Properties properties = new Properties();

        // connect to Localhost
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

        // connect to Conduktor Playground
        /*properties.setProperty("bootstrap.servers", "cluster.playground.cdkt.io:9092");
        properties.setProperty("security.protocol", "SASL_SSL");
        properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"6p362CeoZMDQUsUXEhtLf7\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiI2cDM2MkNlb1pNRFFVc1VYRWh0TGY3Iiwib3JnYW5pemF0aW9uSWQiOjcwMTk1LCJ1c2VySWQiOjgxMTcxLCJmb3JFeHBpcmF0aW9uQ2hlY2siOiI1NmVlZTNkMS1kNDAzLTQ5MzUtYmFlNC1hNTllMzdjYmI5MmYifX0.7-aPqJT0OnRVoXD-aE3FxwwZn4bOnilu1k07jMM1GtE\";");
        properties.setProperty("sasl.mechanism", "PLAIN");*/

        // set producer properties
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // create a Producer Record
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>(TOPIC_NAME, "hello world!!");

        // send data
        producer.send(producerRecord);

        // tell the producer to send all data and block until done -- synchronous
        producer.flush();

        // flush and close the producer
        producer.close();
    }
}
