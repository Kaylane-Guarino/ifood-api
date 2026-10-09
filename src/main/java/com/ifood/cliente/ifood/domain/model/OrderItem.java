package com.ifood.cliente.ifood.domain.model;

import java.math.BigDecimal;

public class OrderItem {
    private Long produtoId;

    private String produtoName;

    private BigDecimal unitPrice;

    private Integer quantity;

    public OrderItem(Long produtoId, String produtoName, BigDecimal unitPrice, Integer quantity) {
        this.produtoId = produtoId;
        this.produtoName = produtoName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public String getProdutoName() {
        return produtoName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
