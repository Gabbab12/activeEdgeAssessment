CREATE TABLE IF NOT EXISTS flyway_schema_history (
                                                     installed_rank INT NOT NULL,
                                                     version VARCHAR(50),
                                                     description VARCHAR(200),
                                                     type VARCHAR(20),
                                                     script VARCHAR(1000),
                                                     checksum INT,
                                                     installed_by VARCHAR(100),
                                                     installed_on TIMESTAMP,
                                                     execution_time INT,
                                                     success BOOLEAN,
                                                     PRIMARY KEY (installed_rank)
);

INSERT INTO flyway_schema_history (installed_rank, version, description, type, script, installed_by, installed_on, execution_time, success)
VALUES (1, '1', 'Baseline', 'BASELINE', 'V1__Create_stocks_table.sql', 'SYSTEM', CURRENT_TIMESTAMP, 0, true);