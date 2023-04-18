package com.example.testCRUD.crud1.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class ControllerF {

    @Autowired
    private service service;
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
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("country", dao.show(id));
//        return "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("country") Country updatedCountry, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "edit";
//        }
//
//        dao.update(id, updatedCountry);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id){
//        dao.delete(id);
//        return "redirect:/";
//    }
//
//    @GetMapping("/new")
//    public String newCountry(Model model) {
//        model.addAttribute("country", new Country());
//        return "new";
//    }
//
//    @PostMapping("/")
//    public String create(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "new";
//        }
//
//        dao.create(country);
//        return "redirect:/";
//    }
}
