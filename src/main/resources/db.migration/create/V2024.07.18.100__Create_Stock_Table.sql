CREATE TABLE IF NOT EXISTS stocks (
                                      id BIGSERIAL PRIMARY KEY,
                                      stock_name VARCHAR(250) UNIQUE,
                                      stock_amount DECIMAL(10, 2),
                                      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
