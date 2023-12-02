package com.example.projet2.service;

import com.example.projet2.entities.Categorie;

import java.util.List;

public interface IServiceCategorie {

    public Categorie createCategorie(Categorie c);
    public Categorie findCategorieById(int id);
    public Categorie updateCategorie(Categorie c);
    public List<Categorie> findAllCategorie();
    public void deleteCategorie(Categorie c);



}
