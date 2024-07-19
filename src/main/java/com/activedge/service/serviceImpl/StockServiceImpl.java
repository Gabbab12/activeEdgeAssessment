package com.activedge.service.serviceImpl;

import com.activedge.dto.StockDto;
import com.activedge.dto.StockResponse;
import com.activedge.entity.Stock;
import com.activedge.exception.BadRequestException;
import com.activedge.exception.StockAlreadyExistException;
import com.activedge.exception.StockNotFoundException;
import com.activedge.repository.StockRepository;
import com.activedge.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    @Override
    public Mono<String> createStock(StockDto dto) {
        return stockRepository.existsByName(dto.getName())
                .flatMap(exists -> {
                    if (exists.equals(true)) {
                        return Mono.error(new StockAlreadyExistException("Stock already exists with this name: " + dto.getName(), HttpStatus.BAD_REQUEST));
                    }

                    Stock stock = new Stock();
                    BeanUtils.copyProperties(dto, stock);
                    return stockRepository.save(stock)
                            .then(Mono.just("Stock successfully created"));
                })
                .onErrorResume(e -> Mono.error(new BadRequestException("Error in creating the stock: " + e.getMessage(), HttpStatus.BAD_REQUEST)));
    }

    @Override
    public Mono<String> updateStock(Long stockId, StockDto dto) {
        return stockRepository.findById(stockId)
                .flatMap(stock -> {
                    BeanUtils.copyProperties(dto, stock);
                    return stockRepository.save(stock)
                            .then(Mono.just("Stock successfully updated"));
                })
                .switchIfEmpty(Mono.error(new StockNotFoundException("Stock not found", HttpStatus.NOT_FOUND)))
                .onErrorResume(e -> Mono.error(new BadRequestException("Error in updating the stock: " + e.getMessage(), HttpStatus.BAD_REQUEST)));
    }

    @Override
    public Mono<StockResponse> getStockById(Long stockId) {
        return stockRepository.findById(stockId)
                .map(stock -> new StockResponse(stock.getName(), stock.getAmount()));
    }

    @Override
    public Flux<StockResponse> getAllStocks() {
        return stockRepository.findAll()
                .map(stock -> new StockResponse(stock.getName(), stock.getAmount()));
    }
}
