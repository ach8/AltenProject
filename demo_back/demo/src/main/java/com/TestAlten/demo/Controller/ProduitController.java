package com.TestAlten.demo.Controller;

import com.TestAlten.demo.model.Produit;
import com.TestAlten.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Produits")
public class ProduitController {

    @Autowired
    private ProduitService ProduitService;

    @PostMapping
    public Produit createProduit(@RequestBody Produit Produit) {
        return ProduitService.createProduit(Produit);
    }

    @GetMapping
    public List<Produit> getAllProduits() {
        return ProduitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Optional<Produit> Produit = ProduitService.getProduitById(id);
        if (Produit.isPresent()) {
            return ResponseEntity.ok(Produit.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit ProduitDetails) {
        Produit updatedProduit = ProduitService.updateProduit(id, ProduitDetails);
        return ResponseEntity.ok(updatedProduit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        ProduitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }
}
