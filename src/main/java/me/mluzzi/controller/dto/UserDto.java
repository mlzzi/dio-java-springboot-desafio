package me.mluzzi.controller.dto;

import me.mluzzi.domain.model.User;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDto(
        Long id,
        String name,
        AccountDto account,
        List<FeatureDto> features,
        List<InvestmentDto> investments,
        List<TransactionDto> transactions) {

    public UserDto(User model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getAccount()).map(AccountDto::new).orElse(null),
                ofNullable(model.getFeatures()).orElse(emptyList()).stream().map(FeatureDto::new).collect(toList()),
                ofNullable(model.getInvestiments()).orElse(emptyList()).stream().map(InvestmentDto::new).collect(toList()),
                ofNullable(model.getTransactions()).orElse(emptyList()).stream().map(TransactionDto::new).collect(toList())
        );
    }

    public User toModel() {
        User model = new User();
        model.setId(this.id);
        model.setName(this.name);
        model.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
        model.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toModel).collect(toList()));
        model.setInvestiments(ofNullable(this.investments).orElse(emptyList()).stream().map(InvestmentDto::toModel).collect(toList()));
        model.setTransactions(ofNullable(this.transactions).orElse(emptyList()).stream().map(TransactionDto::toModel).collect(toList()));
        return model;
    }
}