package com.example.testCRUD.crud1.Service;

import com.example.testCRUD.crud1.DAO.daoHibernate;
import com.example.testCRUD.crud1.Models.Country;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class service {
    @Autowired
    private daoHibernate daoHibernate;
    @Transactional
    public List<Country> index(){
        return daoHibernate.index();
    }
    @Transactional
    public Country show(int id){
        return daoHibernate.show(id);
    }
    @Transactional
    public void delete(int id){
        daoHibernate.delete(id);
    }
    @Transactional
    public void save(Country country){
        daoHibernate.save(country);
    }
    @Transactional
    public void update(int id, Country country){
        daoHibernate.update(id, country);
    }
}