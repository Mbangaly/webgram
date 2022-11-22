package com.webgram.Service;

import com.webgram.Repository.CategorieRepository;
import com.webgram.entity.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements ICategorieService{
    private final CategorieRepository categorieRepository;

    @Override
    public Categorie saveCategorie(Categorie cat) {
        Categorie existing = categorieRepository.findByNom(cat.getNom());
           if(existing != null) {
    throw new RuntimeException("Une catégorie avec le même nom existe déjà");
      }
        return categorieRepository.save(cat);
    }

    @Override
    public Collection<Categorie> listeCategories() {

        return categorieRepository.getAllCategorie();
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie cat) {
        Categorie existing=getcategorie(id);
        existing.setNom(cat.getNom());
        existing.setDescription(cat.getDescription());
        return categorieRepository.save(existing);
    }

    @Override
    public void deletedCategorie(Long id) {
     Categorie existing = getcategorie(id);
     existing.setDeleted(true);
     categorieRepository.save(existing);
    }
    private Categorie getcategorie(Long id) {
        return categorieRepository.findById(id).orElseThrow(()->new RuntimeException("La catégorie recherchée n'existe pas"));
    }
}
