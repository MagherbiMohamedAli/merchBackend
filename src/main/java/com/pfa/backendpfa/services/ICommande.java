package com.pfa.backendpfa.services;

import com.pfa.backendpfa.model.Commande;
import com.pfa.backendpfa.model.LigneCommande;
import com.pfa.backendpfa.model.Produit;
import com.pfa.backendpfa.model.User;

import java.util.List;

public interface ICommande {
  Commande  passerCommande(List<LigneCommande> ligneCommandes, User clients);
  Commande confirmerCommande(Commande cmd);
  Commande annulerCommande(Commande cmd);

}
