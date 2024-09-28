package me.mluzzi.controller.dto;

import me.mluzzi.domain.model.Transaction;

import java.math.BigDecimal;

public record TransactionDto(Long id, String icon, String description, BigDecimal transactionValue) {

    public TransactionDto(Transaction model) {
        this(model.getId(), model.getIcon(), model.getDescription(), model.getTransactionValue());
    }

    public Transaction toModel() {
        Transaction model = new Transaction();
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        model.setTransactionValue(this.transactionValue);
        return model;
    }
}