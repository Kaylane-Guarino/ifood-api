package com.ifood.cliente.ifood.adapter.out.persistence;

import com.ifood.cliente.ifood.application.port.out.OrderRepository;
import com.ifood.cliente.ifood.domain.model.Order;

public class OrderRepositoryAdapter implements OrderRepository {

    @Override
    public Order save(Order order) {
        return order;
    }

}
