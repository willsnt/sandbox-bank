CREATE TABLE accounts (
    account_id BIGSERIAL PRIMARY KEY,
    account_number BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1000000 INCREMENT BY 1) UNIQUE NOT NULL,
    type VARCHAR(20) NOT NULL,
    status VARCHAR(20) DEFAULT 'LOCKED'::character varying NOT NULL,
    pin_hash VARCHAR(255) NOT NULL,
    balance NUMERIC(15, 2) NOT NULL DEFAULT 0.00,
    last_access TIMESTAMP,
    pin_attempts INTEGER DEFAULT 0,
    last_pin_attempt TIMESTAMP,
    locked_until TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at TIMESTAMP,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_client_account FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

create trigger trg_account_updated_at before
    update
    on
        public.accounts for each row execute function set_updated_at();