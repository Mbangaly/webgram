package com.webgram.Service;

import com.webgram.entity.Categorie;

import java.util.Collection;

public interface ICategorieService {
    Categorie saveCategorie(Categorie cat);
    Collection<Categorie> listeCategories();
    Categorie updateCategorie(Long id, Categorie categorie);
    void deletedCategorie(Long id);

}
