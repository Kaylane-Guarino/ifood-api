package com.ifood.cliente.ifood.application.port.in;

import com.ifood.cliente.ifood.domain.model.OrderItem;

import java.util.List;

public record CreateOrderCommand(Long customerId, Long restaurantId, List<OrderItem> items) {
}
