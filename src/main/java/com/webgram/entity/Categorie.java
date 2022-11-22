package com.webgram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false, length = 20)
    private String nom;
    @Column(length = 500)
    private String description;
    private boolean isDeleted = false;
    @OneToMany(mappedBy = "categorie")
    private Collection<Produit> produits;
}
