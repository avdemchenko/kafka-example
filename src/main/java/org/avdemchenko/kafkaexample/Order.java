package org.avdemchenko.kafkaexample;

import java.util.UUID;

public record Order(UUID id, String itemName, Integer userId) {
}
