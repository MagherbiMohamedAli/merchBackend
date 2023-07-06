package com.pfa.backendpfa.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Produit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String nom;
    @Enumerated(EnumType.STRING)
    private EEtat etat;
    private String couleur;



    private float prix;

    @ManyToOne
    private User vendeurs;


}