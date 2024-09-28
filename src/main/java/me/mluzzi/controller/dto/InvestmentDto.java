package me.mluzzi.controller.dto;

import me.mluzzi.domain.model.Investment;

import java.math.BigDecimal;

public record InvestmentDto(Long id, String icon, String description, BigDecimal savings) {

    public InvestmentDto(Investment model) {
        this(model.getId(), model.getIcon(), model.getDescription(), model.getSavings());
    }

    public Investment toModel() {
        Investment model = new Investment();
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        model.setSavings(this.savings);
        return model;
    }
}
