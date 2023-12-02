package com.example.projet2.service;

import com.example.projet2.entities.Acteur;

import java.util.List;

public interface IServiceActeur {
    public Acteur createActeur(Acteur acteur);
    public List<Acteur> getAllActeurs();
}
