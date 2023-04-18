package com.example.testCRUD.crud1.DAO;

import com.example.testCRUD.crud1.Configuration.Config;
import com.example.testCRUD.crud1.Models.Country;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dao {
    public List<Country> index() {
        Config config = new Config();
        String sql = "SELECT * FROM countries";
        return config.jdbcTemplate().query(sql, (rs, rowNum) -> {
            Country person = new Country();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            return person;
        });
    }

    public Country show(int id) {
        Config config = new Config();
        String sql = "SELECT * FROM countries WHERE id=?";
        return config.jdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Country test = new Country();
            test.setId(rs.getInt("id"));
            test.setName(rs.getString("name"));
            test.setArea(rs.getFloat("area"));
            test.setCapital(rs.getString("capital"));
            test.setGdp(rs.getFloat("gdp"));
            test.setPopulation(rs.getInt("population"));
            return test;
        });
    }
    public void delete(int id){
        Config config = new Config();
        String sql = "DELETE FROM countries WHERE id=?";
        config.jdbcTemplate().update(sql, id);
    }

    public void update(int id, Country updatedPerson) {
        Config config = new Config();
        config.jdbcTemplate().update("UPDATE countries SET name=?, area=?, capital=?, population=?, gdp=? WHERE id=?",
                updatedPerson.getName(), updatedPerson.getArea(), updatedPerson.getCapital(), updatedPerson.getPopulation(), updatedPerson.getGdp(), id);
    }
    public void create(Country newCountry) {
        Config config = new Config();
        String sql = "INSERT INTO countries (name, area, capital, population, gdp) VALUES (?, ?, ?, ?, ?)";
        config.jdbcTemplate().update(sql, newCountry.getName(), newCountry.getArea(), newCountry.getCapital(), newCountry.getPopulation(), newCountry.getGdp());
    }
}
