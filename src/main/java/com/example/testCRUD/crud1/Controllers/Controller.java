package com.example.testCRUD.crud1.Controllers;
import com.example.testCRUD.crud1.DAO.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class Controller {
    private dao dao;
    @Autowired
    public Controller(com.example.testCRUD.crud1.DAO.dao dao) {
        this.dao = dao;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listOfCountry", dao.index());
        return "index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("country", dao.show(id));
        return "show";
    }
}
