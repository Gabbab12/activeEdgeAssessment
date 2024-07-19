package com.activedge.service;

import com.activedge.dto.StockDto;
import com.activedge.dto.StockResponse;
import com.activedge.entity.Stock;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StockService {

    Mono<String> createStock(StockDto dto);

    Mono<String> updateStock(Long stockId, StockDto dto);

    Mono<StockResponse> getStockById(Long stockId);

    Flux<StockResponse> getAllStocks();
}
