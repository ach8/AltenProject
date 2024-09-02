package com.TestAlten.demo.repository;

import com.TestAlten.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
