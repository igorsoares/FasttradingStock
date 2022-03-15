package com.solinftec.webbroker.fasttrading_stocks.controller;

import java.util.List;

import com.solinftec.webbroker.fasttrading_stocks.dto.FullStockDto;
import com.solinftec.webbroker.fasttrading_stocks.dto.StockUpdate;
import com.solinftec.webbroker.fasttrading_stocks.model.Stock;
import com.solinftec.webbroker.fasttrading_stocks.services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    StockService stockService;

    @CrossOrigin
    @GetMapping
    public List<Stock> getAllStocks() {
        return this.stockService.getAllStocks();
    }

    @PutMapping(value = "/update/{idStock}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FullStockDto> updateStock(@PathVariable Integer idStock,
            @RequestBody StockUpdate stockUpdate) throws Exception {
        return ResponseEntity.ok().body(stockService.updateStock(stockUpdate));
    }

    @GetMapping("/{idStock}")
    public ResponseEntity<FullStockDto> getStockById(@RequestHeader("Authorization") String bearerToken,
            @PathVariable("idStock") Integer idStock) throws Exception {
        return ResponseEntity.ok().body(this.stockService.getStockById(idStock));
    }
}
