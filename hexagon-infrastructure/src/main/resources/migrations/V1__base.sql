CREATE TABLE IF NOT EXISTS account (
 id    SERIAL,
 name   VARCHAR(100) NOT NULL,
 email   VARCHAR(100) NOT NULL,
 password   VARCHAR(100) NOT NULL,
 created_at BIGINT NOT NULL,
 updated_at BIGINT NOT NULL,
 version INT NOT NULL,
 PRIMARY KEY (id)
);