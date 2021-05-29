[![Maven Central](https://img.shields.io/maven-central/v/io.github.susimsek/spring-boot-kafka-starter.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.susimsek/spring-boot-kafka-starter)

# Spring Boot Kafka Starter
This is a spring boot starter to use Kafka.

<img src="https://github.com/susimsek/spring-boot-kafka-starter/blob/main/images/spring-boot-kafka-starter.png" alt="Spring Boot Starter Kafka" width="100%" height="100%"/>

## Features
- [x] Auto configuration.
- [x] Kafka JsonDeserializer and JsonSerializer.

## Kafka Docker Compose Installation

### Prerequisites

- [`Docker`](https://www.docker.com/)
- [`Docker-Compose`](https://docs.docker.com/compose/install/)

### Start Environment

- Open a terminal and inside `docker` root folder run
  ```
  docker-compose up -d
  ```

### Useful Links

- **Kafka**

  `Kafka` can be accessed at localhost:9092

- **Kafka Topics UI**

  `Kafka Topics UI` can be accessed at http://localhost:9000

## Installation

Add the starter module to your dependencies.

maven dependency:

```xml
<dependency>
    <groupId>io.github.susimsek</groupId>
    <artifactId>spring-boot-kafka-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Spring Boot Properties

That is default working configuration.

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