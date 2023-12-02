package com.example.projet2.controller;

import com.example.projet2.entities.Categorie;
import com.example.projet2.entities.Film;
import com.example.projet2.service.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Categories")
public class RestCategorieController {

    @Autowired
    IServiceCategorie iServiceCategorie;

    @GetMapping("")
    public List<Categorie> getAll()
    {
        return iServiceCategorie.findAllCategorie();
    }
    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable int id) {
        return iServiceCategorie.findCategorieById(id);
    }
    @PostMapping("/add")
    public Categorie addCategorie(@RequestBody Categorie newCategorie) {
        return iServiceCategorie.createCategorie(newCategorie);
    }
    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        iServiceCategorie.deleteCategorie(iServiceCategorie.findCategorieById(id));
        return "Le Categorie avec l'ID " + id + " a été supprimé. ";
    }
    @PutMapping ("/update")
    public String delete (@RequestBody Categorie newCategorie) {
        iServiceCategorie.updateCategorie(newCategorie);
        return "Le film avec l'ID " + newCategorie.getId() + " mis à jour ";
    }



}
