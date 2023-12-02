package com.example.projet2.service;


import com.example.projet2.entities.Categorie;
import com.example.projet2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategorie implements IServiceCategorie{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Categorie createCategorie(Categorie c) {
        return categoryRepository.save(c);
    }

    @Override
    public Categorie findCategorieById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        return categoryRepository.save(c);
    }

    @Override
    public List<Categorie> findAllCategorie() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategorie(Categorie c) {
        categoryRepository.delete(c);

    }
}
