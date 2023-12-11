package ru.job4j.cars.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String path;
}
