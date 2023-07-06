package com.pfa.backendpfa.services;

import com.pfa.backendpfa.model.Produit;
import com.pfa.backendpfa.model.User;

import java.util.List;

public interface IProduit {
    Produit ajouterProduit(Produit p);
    List<Produit> afficherTousLesProduitConfirmer();
    List<Produit> afficherTousLesProduit();
    Produit miseajourProduit(Produit p);
    Produit afficherProduitparid(Long id);
    Boolean supprimerProduit(Produit p);;

    Produit annulerProduit(Long id);
    Produit confirmerProduit(Long id);
    List<Produit> affichierProduitParTitre(String titre);
}
