package com.activedge.repository;

import com.activedge.entity.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {
    Mono<Object> existsByName(String name);
}
