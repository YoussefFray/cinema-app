package com.example.projet2.controller;


import com.example.projet2.entities.Film;
import com.example.projet2.service.IServiceFilm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/films")
public class RestFilmController {
    @Autowired
    IServiceFilm iServiceFilm;

    @GetMapping("")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<Film> getAll()
    {
return iServiceFilm.findAllFilms();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Film getFilmById(@PathVariable int id) {
        return iServiceFilm.findFilmById(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Film addFilm(@RequestBody Film newFilm) {
        return iServiceFilm.createFilm(newFilm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String delete (@PathVariable int id) {
        iServiceFilm.deleteFilm(iServiceFilm.findFilmById(id));
        return "Le film avec l'ID " + id + " a été supprimé. ";
    }
    @PutMapping ("/update")
    public String delete (@RequestBody Film newFilm) {
        iServiceFilm.updateFilm(newFilm);
        return "Le film avec l'ID " + newFilm.getId() + " mis à jour ";
    }
    @GetMapping("/byYear/{annee}")
    public List<Film> getFilmsByYear(@PathVariable int annee) {
        return iServiceFilm.findFilmsByYear(annee);
    }

}
