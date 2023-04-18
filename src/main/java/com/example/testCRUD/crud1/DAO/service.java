package com.example.testCRUD.crud1.DAO;

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
}
