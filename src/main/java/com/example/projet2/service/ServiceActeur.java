package com.example.projet2.service;

import com.example.projet2.entities.Acteur;
import com.example.projet2.repository.ActeurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ServiceActeur implements IServiceActeur{
    @Autowired
    private  ActeurRepository acteurRepository;
    @Override
    public Acteur createActeur(Acteur acteur) {

        return acteurRepository.save(acteur);
    }

    @Override
    public List<Acteur> getAllActeurs() {
        return acteurRepository.findAll();
    }
}
