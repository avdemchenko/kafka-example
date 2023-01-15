package org.avdemchenko.kafkaexample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderPublisher {

    @Value("${app.kafka.orders-topic}")
    private String topic;

    private final KafkaTemplate<String, Order> orderKafkaTemplate;

    public void publish(final Order order) {
        orderKafkaTemplate.send(topic, order.id().toString(), order);
    }
}
