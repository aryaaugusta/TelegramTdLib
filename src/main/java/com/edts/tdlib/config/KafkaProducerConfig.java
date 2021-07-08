package com.edts.tdlib.config;

/*
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
*/

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration for Kafka Producer.
 */
//@Configuration
public class KafkaProducerConfig {
    //@Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * Create kafka producer factory with default setup from application properties
     * and {@link StringSerializer} key and value serializer
     *
     * @return ProducerFactory
     */
   /* @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }*/

    /**
     * Create producer kafka template from {@link KafkaProducerConfig#producerFactory}
     *
     * @return KafkaTemplate
     */
  /*  @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }*/
}
