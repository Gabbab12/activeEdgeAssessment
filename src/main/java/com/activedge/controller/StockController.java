package com.activedge.controller;

import com.activedge.dto.StockDto;
import com.activedge.dto.StockResponse;
import com.activedge.entity.Stock;
import com.activedge.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    @PostMapping("/create")
    public Mono<ResponseEntity<String>> createStock(@RequestBody StockDto dto) {
        return stockService.createStock(dto)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage())));
    }

    @PutMapping("/update/{stockId}")
    public Mono<ResponseEntity<String>> updateStock(@PathVariable Long stockId, @RequestBody StockDto dto) {
        return stockService.updateStock(stockId, dto)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage())));
    }

    @GetMapping("/get-one-stock/{stockId}")
    public Mono<StockResponse> getStockById(@PathVariable Long stockId) {
        return stockService.getStockById(stockId);
    }

    @GetMapping("/get-all-stocks")
    public Flux<StockResponse> getAllStocks() {
        return stockService.getAllStocks();
    }
}
