package me.mluzzi.controller.dto;

import me.mluzzi.domain.model.Account;

import java.math.BigDecimal;

public record AccountDto(Long id, String number, String agency, BigDecimal balance) {

    public AccountDto(Account model) {
        this(model.getId(), model.getNumber(), model.getAgency(), model.getBalance());
    }

    public Account toModel() {
        Account model = new Account();
        model.setId(this.id);
        model.setNumber(this.number);
        model.setAgency(this.agency);
        model.setBalance(this.balance);
        return model;
    }

}
