package com.TestAlten.demo.service;


import com.TestAlten.demo.model.Produit;
import com.TestAlten.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository ProduitRepository;

    public Produit createProduit(Produit Produit) {
        return ProduitRepository.save(Produit);
    }

    public List<Produit> getAllProduits() {
        return ProduitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return ProduitRepository.findById(id);
    }

    public Produit updateProduit(Long id, Produit ProduitDetails) {
        Produit Produit = ProduitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("pas de Produit disponible avec l'id " + id));

        Produit.setCode(ProduitDetails.getCode());
        Produit.setName(ProduitDetails.getName());
        Produit.setDescription(ProduitDetails.getDescription());
        Produit.setImage(ProduitDetails.getImage());
        Produit.setCategory(ProduitDetails.getCategory());
        Produit.setPrice(ProduitDetails.getPrice());
        Produit.setQuantity(ProduitDetails.getQuantity());
        Produit.setInternalReference(ProduitDetails.getInternalReference());
        Produit.setShellId(ProduitDetails.getShellId());
        Produit.setInventoryStatus(ProduitDetails.getInventoryStatus());
        Produit.setRating(ProduitDetails.getRating());

        return ProduitRepository.save(Produit);
    }

    public void deleteProduit(Long id) {
        Produit Produit = ProduitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("pas de Produit disponible avec l'id " + id));

        ProduitRepository.delete(Produit);
    }
}
