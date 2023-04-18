package com.example.testCRUD.crud1.DAO;

import com.example.testCRUD.crud1.Models.Country;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class daoHibernate {

    @Autowired
    private EntityManager manager;
    public List<Country> index(){
        Session session = manager.unwrap(Session.class);
        Query<Country>manQuery = session.createQuery("from Country",Country.class);
        return manQuery.getResultList();
    }
    public Country show(int id){
        Session session = manager.unwrap(Session.class);
        return session.get(Country.class, id);
    }
    public void delete(int id){
        Session session = manager.unwrap(Session.class);
        Country country = session.get(Country.class, id);
        session.delete(country);
    }
}
