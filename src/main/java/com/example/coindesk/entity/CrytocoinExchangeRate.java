package com.example.coindesk.entity;

import java.time.LocalDate;

public class CrytocoinExchangeRate {
    private int id;
    private int crytocoin_id;
    private String crytocoin_code;
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private double rateFloat;
    private LocalDate createAt;
    private LocalDate updateAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrytocoin_id() {
        return crytocoin_id;
    }

    public void setCrytocoin_id(int crytocoin_id) {
        this.crytocoin_id = crytocoin_id;
    }

    public String getCrytocoin_code() {
        return crytocoin_code;
    }

    public void setCrytocoin_code(String crytocoin_code) {
        this.crytocoin_code = crytocoin_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(double rateFloat) {
        this.rateFloat = rateFloat;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }
}
