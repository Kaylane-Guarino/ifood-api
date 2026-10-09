package com.ifood.cliente.ifood.application.port.in;

import com.ifood.cliente.ifood.domain.model.Order;

public interface CreateOrderUseCase {

    Order execute(CreateOrderCommand command);

}
