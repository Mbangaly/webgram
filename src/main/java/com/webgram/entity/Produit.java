package com.webgram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "produits")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String reference;
    @Column(nullable = false, length = 25)
    private String code;
    @Column(nullable = false, length = 100)
    private String libelle;
    @Column(length = 500)
    private String description;
    private boolean isDeleted = false;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
