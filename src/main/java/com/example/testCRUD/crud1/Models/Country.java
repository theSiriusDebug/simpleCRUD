package com.example.testCRUD.crud1.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    private int id;

    private String name;

    private String capital;

    private int population;

    private float area;

    private float gdp;

    // геттеры и сеттеры

}
