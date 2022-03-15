package com.solinftec.webbroker.fasttrading_stocks.dto;

import java.math.BigDecimal;

public class StockUpdate {

    private Integer id;

    private BigDecimal ask_min;
    private BigDecimal ask_max;
    private BigDecimal bid_min;
    private BigDecimal bid_max;

    public StockUpdate() {

    }

    public StockUpdate(Integer id, BigDecimal ask_min, BigDecimal ask_max, BigDecimal bid_min, BigDecimal bid_max) {
        this.id = id;
        this.ask_min = ask_min;
        this.ask_max = ask_max;
        this.bid_min = bid_min;
        this.bid_max = bid_max;
    }

    @Override
    public String toString() {
        return "StockUpdate [ask_max=" + ask_max + ", ask_min=" + ask_min + ", bid_max=" + bid_max + ", bid_min="
                + bid_min + ", id=" + id + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
