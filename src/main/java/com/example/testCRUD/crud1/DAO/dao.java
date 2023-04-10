package com.example.testCRUD.crud1.DAO;

import com.example.testCRUD.crud1.Configuration.Config;
import com.example.testCRUD.crud1.Models.Country;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
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

    public Country show(int id){
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
}
