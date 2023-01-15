package org.avdemchenko.kafkaexample;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderPublisher publisher;

    @PostMapping("/orders")
    public String send(@RequestBody final OrderRequest request) {
        final Order order = new Order(UUID.randomUUID(), request.item(), request.userId());

        publisher.publish(order);
        return "Order: " + order.id() + " has been sent";
    }

    public record OrderRequest(String item, Integer userId){}
}
