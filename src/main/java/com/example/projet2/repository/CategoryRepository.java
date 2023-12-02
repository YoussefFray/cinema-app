package com.example.projet2.repository;

import com.example.projet2.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categorie, Integer> {
}
