package com.ifood.cliente.ifood.application.port.out;

import com.ifood.cliente.ifood.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
