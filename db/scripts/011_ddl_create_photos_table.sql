CREATE TABLE photos
(
    id     serial primary key,
    path   varchar,
    car_id int references cars (id)
);