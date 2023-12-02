package com.example.projet2.controller;

import com.example.projet2.entities.Film;
import com.example.projet2.service.IServiceCategorie;
import com.example.projet2.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/film/")
public class FilmController {
    @Autowired
    IServiceFilm iServiceFilm;
    @Autowired
    IServiceCategorie iServiceCategorie;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("all")
    public String all(Model model){
        model.addAttribute("films", iServiceFilm.findAllFilms());
        return "affiche";
    }
    @GetMapping("new")
    public String afficheNewForm(Model model) {
        model.addAttribute("categories", iServiceCategorie.findAllCategorie());
        return "ajout";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("add")
    public String add(Film f) {
        iServiceFilm.createFilm(f);
        return "redirect:/film/all";
    }
    @GetMapping("delete/{id}")
    public String delete (@PathVariable int id) {
        iServiceFilm.deleteFilm(iServiceFilm.findFilmById(id));
        return "redirect:/film/all";
    }
    @GetMapping("edit/{id}")
    public String editFilm(@PathVariable int id, Model model) {
        Film film = iServiceFilm.findFilmById(id);

        if (film != null) {
            model.addAttribute("film", film);
            model.addAttribute("categories", iServiceCategorie.findAllCategorie());
            return "edit"; // Assuming you have an "edit.html" view
        } else {
            return "redirect:/film/all";
        }
    }

    @PostMapping("update")
    public String updateFilm(Film film) {
        iServiceFilm.updateFilm(film);
        return "redirect:/film/all";
    }
}
