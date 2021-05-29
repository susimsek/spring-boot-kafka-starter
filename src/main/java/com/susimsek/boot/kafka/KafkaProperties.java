package com.susimsek.boot.kafka;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {

    String bootstrapServers = "localhost:9092";
    String consumerGroupId = "group-id";
}
