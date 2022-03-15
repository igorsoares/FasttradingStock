package com.solinftec.webbroker.fasttrading_stocks.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.solinftec.webbroker.util.StockUtil;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String stock_symbol;
    @Column(nullable = false)
    private String stock_name;

    private BigDecimal ask_min;
    private BigDecimal ask_max;
    private BigDecimal bid_min;
    private BigDecimal bid_max;

    @CreationTimestamp
    private LocalDateTime created_on;
    @UpdateTimestamp
    private LocalDateTime update_on;

    public Stock(String stock_symbol, String stock_name, BigDecimal ask_min, BigDecimal ask_max, BigDecimal bid_min,
            BigDecimal bid_max, LocalDateTime created_on, LocalDateTime update_on) {
        this.stock_symbol = stock_symbol;
        this.stock_name = stock_name;
        this.ask_min = ask_min;
        this.ask_max = ask_max;
        this.bid_min = bid_min;
        this.bid_max = bid_max;
        this.created_on = created_on;
        this.update_on = update_on;
    }

    public Stock() {

    }

    @Override
    public String toString() {
        return "Stocks [ask_max=" + ask_max + ", ask_min=" + ask_min + ", bid_max=" + bid_max + ", bid_min=" + bid_min
                + ", created_on=" + created_on + ", id=" + id + ", stock_name=" + stock_name + ", stock_symbol="
                + stock_symbol + ", update_on=" + update_on + "]";
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
        this.ask_min = StockUtil.formatNumber(ask_min);
    }

    public BigDecimal getAsk_max() {
        return ask_max;
    }

    public void setAsk_max(BigDecimal ask_max) {
        this.ask_max = StockUtil.formatNumber(ask_max);
    }

    public BigDecimal getBid_min() {
        return bid_min;
    }

    public void setBid_min(BigDecimal bid_min) {
        this.bid_min = StockUtil.formatNumber(bid_min);
    }

    public BigDecimal getBid_max() {
        return bid_max;
    }

    public void setBid_max(BigDecimal bid_max) {
        this.bid_max = StockUtil.formatNumber(bid_max);
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
