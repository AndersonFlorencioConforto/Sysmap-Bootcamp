package com.sysmap.mslearningcad.configs;

import java.io.Serializable;
import java.util.HashMap;

import com.acme.avro.Student;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;

@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, Student> producerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configs.put(SCHEMA_REGISTRY_URL_CONFIG,"http://127.0.0.1:8081");
        return new DefaultKafkaProducerFactory<>(configs);
    }


    @Bean
    public KafkaTemplate<String, Student> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    //2.7
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("topic-student").partitions(2).replicas(1).build()
        );

    }
}
