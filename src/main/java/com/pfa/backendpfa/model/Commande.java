package com.pfa.backendpfa.model;

import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Commande{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EEtat etat;
    private Float prix;
    private Date datecommande;
    @ManyToMany
    private List<LigneCommande> ligneCommandes;
    @ManyToOne
    private User client;

}
