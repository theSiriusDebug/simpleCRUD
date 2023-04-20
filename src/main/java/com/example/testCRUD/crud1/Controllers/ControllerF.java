package com.example.testCRUD.crud1.Controllers;

import com.example.testCRUD.crud1.Models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class ControllerF {

    @Autowired
    private com.example.testCRUD.crud1.Service.service service;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("service", service.index());
        return "index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("man", service.show(id));
        return "show";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        service.delete(id);
        System.out.println("deleted");
        return "redirect:/";
    }
    @GetMapping("/new")
    public String newCountry(Model model){
        Country country = new Country();
        model.addAttribute("man", country);
        return "new";
    }
    @PostMapping("/new")
    public String create(@ModelAttribute("man") Country country){
        service.save(country);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("man", service.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("man")
                         Country updatedCountry, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        service.update(id, updatedCountry);
        return "redirect:/{id}";
    }
}
