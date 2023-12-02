package com.example.projet2.service;

import com.example.projet2.entities.Film;

import java.util.List;
import java.util.Map;

public interface IServiceFilm {
    public Film createFilm(Film f);
    public Film findFilmById(int id);
    public Film updateFilm(Film f);
    public List<Film> findAllFilms();
    public void deleteFilm(Film f);

    public List<Film> findFilmsByYear(int anneeparution);

}
