package com.webgram.web;

import com.webgram.Service.CategorieServiceImpl;
import com.webgram.entity.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class CategorieController {
    private final CategorieServiceImpl categorieService;

    @PostMapping("/api/webgram/v1/add")
    public ResponseEntity<Categorie> ajoutercategorie(@RequestBody Categorie categorie) {
        Categorie cat = categorieService.saveCategorie(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    @GetMapping ("api/webgram/v1/liste")
    public ResponseEntity<Collection<Categorie>> listeCategorie() {
        Collection<Categorie> listeCat = categorieService.listeCategories();
        return ResponseEntity.ok(listeCat);
    }

    @PutMapping("/api/webgram/v1/update/{id}")
    public ResponseEntity<Categorie> modifierCategorie(@PathVariable Long id, @RequestBody Categorie categorie) {
        Categorie cat = categorieService.updateCategorie(id,categorie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);
    }

    @DeleteMapping("/api/webgram/v1/delete/{id}")
    public ResponseEntity<Object> supprimerCategorie(@PathVariable Long id) {
        categorieService.deletedCategorie(id);
        return ResponseEntity.noContent().build();
    }
}
