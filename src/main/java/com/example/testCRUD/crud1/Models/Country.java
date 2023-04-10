package com.example.testCRUD.crud1.Models;

public class Country {
    private int id;
    private String name;
    private String capital;
    private int population;
    private float area;
    private float gdp;

    public Country(String name, int id, String capital, int population, float area, float gdp) {
        this.name = name;
        this.id = id;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.gdp = gdp;
    }
    public Country() {}

    //ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //NAME
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //CAPITAL
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }

    //POPULATION
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    //AREA
    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }

    //GDP
    public float getGdp() {
        return gdp;
    }
    public void setGdp(float gdp) {
        this.gdp = gdp;
    }
}
