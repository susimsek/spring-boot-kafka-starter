package io.susimsek.kafka.demo.service;

import io.susimsek.kafka.demo.common.AppConstants;
import io.susimsek.kafka.demo.model.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafKaConsumerService {


    @KafkaListener(topics = AppConstants.TOPIC_NAME_USER, groupId = AppConstants.GROUP_ID)
    public void consume(User user) {
        System.out.println();
        log.info(String.format("User created -> %s", user));
    }
}
