package com.solinftec.webbroker.fasttrading_stocks.repository;

import com.solinftec.webbroker.fasttrading_stocks.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksRepository extends JpaRepository<Stock, Integer> {

}
