package com.epam.training.microservices.taxiorderservice;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
public class TaxiOrderServiceApplication {

    public static void main(String[] args) {
//        String bootstrapServers = "127.0.0.1:9092";
//        Properties properties = new Properties();
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//
//        KafkaProducer<String, String> producer = new KafkaProducer(properties);
//        ProducerRecord<String, String> record = new ProducerRecord("first_topic", "hello world");
//        producer.send(record);
//        producer.close();
        SpringApplication.run(TaxiOrderServiceApplication.class, args);
    }

}
