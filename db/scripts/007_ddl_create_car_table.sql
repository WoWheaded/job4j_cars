CREATE TABLE cars
(
    id        serial primary key,
    name      VARCHAR NOT NULL,
    engine_id int     not null unique references engines (id)
);