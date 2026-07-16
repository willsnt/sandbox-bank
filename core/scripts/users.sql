CREATE TABLE users (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE'::character varying NOT NULL,
    last_login TIMESTAMP,
    login_attempts INTEGER NOT NULL DEFAULT 0,
    locked_until TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_client_user FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

create trigger trg_user_updated_at before
    update
    on
        public.users for each row execute function set_updated_at();