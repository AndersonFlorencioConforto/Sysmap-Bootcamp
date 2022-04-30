package com.sysmap.mslearningattendance.configs;

import java.util.HashMap;

import com.acme.avro.Student;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static io.confluent.kafka.serializers.KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG;

//@Configuration
//@EnableKafka
public class KafkaConfig {

//    @Autowired
//    private KafkaProperties kafkaProperties;
//
//    @Bean
//    public ConsumerFactory<String, Student> consumerFactory() {
//        var configs = new HashMap<String,Object>();
//        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
//        configs.put(SCHEMA_REGISTRY_URL_CONFIG,"http://127.0.0.1:8081");
//        configs.put(SPECIFIC_AVRO_READER_CONFIG,true);
//        return new DefaultKafkaConsumerFactory<>(configs);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Student> kafkaListenerContainerFactory() {
//        var factory = new ConcurrentKafkaListenerContainerFactory<String,Student>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }

}
