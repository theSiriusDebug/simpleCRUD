package com.example.testCRUD.crud1.Controllers;
import com.example.testCRUD.crud1.DAO.dao;
import com.example.testCRUD.crud1.Models.Country;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("country", dao.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("country") Country updatedCountry, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        dao.update(id, updatedCountry);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        dao.delete(id);
        return "redirect:/";
    }
}
