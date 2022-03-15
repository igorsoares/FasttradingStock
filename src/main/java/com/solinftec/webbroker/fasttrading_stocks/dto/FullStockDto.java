package com.solinftec.webbroker.fasttrading_stocks.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solinftec.webbroker.fasttrading_stocks.model.Stock;

public class FullStockDto {
    private Integer id;
    private String stock_symbol;
    private String stock_name;

    private BigDecimal ask_min;
    private BigDecimal ask_max;
    private BigDecimal bid_min;
    private BigDecimal bid_max;

    private LocalDateTime created_on;
    private LocalDateTime update_on;

    @JsonIgnore
    public Stock getModel() {
        Stock stock = new Stock();
        stock.setId(id);
        stock.setStock_symbol(stock_symbol);
        stock.setStock_name(stock_name);
        stock.setAsk_min(ask_min);
        stock.setAsk_max(ask_max);
        stock.setBid_min(bid_min);
        stock.setBid_max(bid_max);
        stock.setCreated_on(created_on);
        stock.setUpdate_on(update_on);
        return stock;
    }

    public FullStockDto(Stock stockModel) {
        this.id = stockModel.getId();
        this.stock_symbol = stockModel.getStock_symbol();
        this.stock_name = stockModel.getStock_name();
        this.ask_min = stockModel.getAsk_min();
        this.ask_max = stockModel.getAsk_max();
        this.bid_min = stockModel.getBid_min();
        this.bid_max = stockModel.getBid_max();
        this.created_on = stockModel.getCreated_on();
        this.update_on = stockModel.getUpdate_on();
    }

    public FullStockDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStock_symbol() {
        return stock_symbol;
    }

    public void setStock_symbol(String stock_symbol) {
        this.stock_symbol = stock_symbol;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public BigDecimal getAsk_min() {
        return ask_min;
    }

    public void setAsk_min(BigDecimal ask_min) {
        this.ask_min = ask_min;
    }

    public BigDecimal getAsk_max() {
        return ask_max;
    }

    public void setAsk_max(BigDecimal ask_max) {
        this.ask_max = ask_max;
    }

    public BigDecimal getBid_min() {
        return bid_min;
    }

    public void setBid_min(BigDecimal bid_min) {
        this.bid_min = bid_min;
    }

    public BigDecimal getBid_max() {
        return bid_max;
    }

    public void setBid_max(BigDecimal bid_max) {
        this.bid_max = bid_max;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public LocalDateTime getUpdate_on() {
        return update_on;
    }

    public void setUpdate_on(LocalDateTime update_on) {
        this.update_on = update_on;
    }

}
