package com.solinftec.webbroker.fasttrading_stocks.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solinftec.webbroker.fasttrading_stocks.dto.FullStockDto;
import com.solinftec.webbroker.fasttrading_stocks.dto.StockUpdate;
import com.solinftec.webbroker.fasttrading_stocks.model.Stock;
import com.solinftec.webbroker.fasttrading_stocks.repository.StocksRepository;

import org.springframework.stereotype.Service;

@Service
public class StockService {

    StocksRepository stockRepository;

    public StockService(StocksRepository stockRepository){
        this.stockRepository=stockRepository;
    }

    private static final Logger LOGGER = Logger.getLogger("StockService");
    private static final String STOCK_DOES_NOT_EXISTS="STOCK_DOES_NOT_EXISTS";

    public List<Stock> getAllStocks() {
        return this.stockRepository.findAll();
    }

    private Stock getStockModelByStockUpdate(StockUpdate stockUpdateDto) throws Exception {
        Optional<Stock> stock = this.stockRepository.findById(stockUpdateDto.getId());
        if (stock.isPresent()) {
            Stock stockModel = stock.get();
            stockModel.setAsk_max(stockUpdateDto.getAsk_max());
            stockModel.setAsk_min(stockUpdateDto.getAsk_min());
            stockModel.setBid_max(stockUpdateDto.getBid_max());
            stockModel.setBid_min(stockUpdateDto.getBid_min());
            return stockModel;
        }
        throw new Exception(STOCK_DOES_NOT_EXISTS);
    }

    public FullStockDto getStockById(Integer idStock) throws Exception {
        Optional<Stock> optionalStock = this.stockRepository.findById(idStock);
        if (optionalStock.isPresent())
            return new FullStockDto(optionalStock.get());
        throw new Exception(STOCK_DOES_NOT_EXISTS);
    }

    public FullStockDto updateStock(StockUpdate stockUpdate) throws Exception {
        Optional<Stock> optionalStock = this.stockRepository.findById(stockUpdate.getId());
        if (optionalStock.isPresent()) {
            Stock stockModel = this.stockRepository.save(getStockModelByStockUpdate(stockUpdate));
            LOGGER.log(Level.INFO,"Stock updated : {0}",stockModel);
            return new FullStockDto(stockModel);
        }
        throw new Exception(STOCK_DOES_NOT_EXISTS);
    }

}
