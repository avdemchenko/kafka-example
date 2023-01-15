package org.avdemchenko.kafkaexample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderConsumer {

    @KafkaListener(
            id = "orders-listener",
            idIsGroup = false,
            groupId = "orders-listener-group",
            topics = "${app.kafka.orders-topic}"
    )
    public void consumeRecord(final ConsumerRecord<String, Order> record) {
        log.info("[1] Received record on {}-{}: {}={}", record.partition(), record.offset(), record.key(), record.value());
    }
}
