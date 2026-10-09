package com.ifood.cliente.ifood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;

    private Long customerId;

    private Long restaurantId;

    private List<OrderItem> items;

    private BigDecimal total;

    private OrderStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Order(
            Long id,
            Long customerId,
            Long restaurantId,
            List<OrderItem> items
    ) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.items = new ArrayList<>(items);
        this.status = OrderStatus.RECEIVED;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        calculateTotal();
    }

    public void calculateTotal() {
        this.total = items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void startPreparation() {

        if (status != OrderStatus.RECEIVED) {
            throw new IllegalStateException(
                    "Pedido não pode entrar em preparação."
            );
        }

        status = OrderStatus.IN_PREPARATION;
        updatedAt = LocalDateTime.now();
    }

    public void markReady() {

        if (status != OrderStatus.IN_PREPARATION) {
            throw new IllegalStateException(
                    "Pedido não está em preparação."
            );
        }

        status = OrderStatus.READY;
        updatedAt = LocalDateTime.now();
    }

    public void sendToDelivery() {

        if (status != OrderStatus.READY) {
            throw new IllegalStateException(
                    "Pedido ainda não está pronto."
            );
        }

        status = OrderStatus.OUT_FOR_DELIVERY;
        updatedAt = LocalDateTime.now();
    }

    public void complete() {

        if (status != OrderStatus.OUT_FOR_DELIVERY) {
            throw new IllegalStateException(
                    "Pedido ainda não está em entrega."
            );
        }

        status = OrderStatus.COMPLETED;
        updatedAt = LocalDateTime.now();
    }

    public void cancel() {

        if (status == OrderStatus.COMPLETED) {
            throw new IllegalStateException(
                    "Pedido concluído não pode ser cancelado."
            );
        }

        status = OrderStatus.CANCELLED;
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}