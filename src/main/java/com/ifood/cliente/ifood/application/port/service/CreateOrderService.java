package com.ifood.cliente.ifood.application.port.service;

import com.ifood.cliente.ifood.application.port.in.CreateOrderCommand;
import com.ifood.cliente.ifood.application.port.in.CreateOrderUseCase;
import com.ifood.cliente.ifood.application.port.out.OrderRepository;
import com.ifood.cliente.ifood.domain.model.Order;

public class CreateOrderService implements CreateOrderUseCase {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order execute(CreateOrderCommand command) {
        Order order = new Order(
                null,
                command.customerId(),
                command.restaurantId(),
                command.items()
        );

        return orderRepository.save(order);
    }

}
