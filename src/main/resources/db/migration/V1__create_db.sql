CREATE table Client(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) not null CHECK(LENGTH(name) between 3 and 200)
);

CREATE TABLE Planet(
    id VARCHAR(200) PRIMARY KEY CHECK (id REGEXP '^[A-Z0-9]+$'),
    name VARCHAR(500) CHECK ( LENGTH(name) between 1 and 500)
);

CREATE TABLE Ticket(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at TIMESTAMP,
    client_id BIGINT,
    from_planet_id VARCHAR(200),
    to_planet_id VARCHAR(200),
    foreign key (client_id) REFERENCES Client(id),
    foreign key (from_planet_id) REFERENCES Planet(id),
    foreign key (to_planet_id) REFERENCES Planet(id)
);