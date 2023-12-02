package com.example.projet2.repository;

import com.example.projet2.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByAnneeparution(int anneeparution);

}
