[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.susimsek/spring-boot-kafka-starter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.susimsek/spring-boot-kafka-starter)
# Spring Boot Kafka Starter
This is a spring boot starter to use Kafka.

## Features
- [x] Auto configuration.
- [x] Kafka JsonDeserializer and JsonSerializer.

## Quick Start

maven dependency:

```xml
<dependency>
    <groupId>io.github.susimsek</groupId>
    <artifactId>spring-boot-kafka-starter</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Spring Boot Properties
application.properties

```
kafka.bootstrap-servers=localhost:9092
kafka.consumer.group-id=group-id
```

### Kafka Producer JsonSerializer Example

```java
@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void saveCreateUserLog(User user) {
        kafkaTemplate.send("user", user);
    }
}

```

### Kafka Consumer JsonDeserializer Example

```java
@Service
public class KafKaConsumerService {
    
    @KafkaListener(topics = "user", groupId = "group-id")
    public void consume(User user) {
        System.out.println(String.format("User created -> %s", user));
    }
}

```