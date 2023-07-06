package com.pfa.backendpfa.dao;

import com.pfa.backendpfa.model.EEtat;
import com.pfa.backendpfa.model.Produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProduitDao extends JpaRepository<Produit, Long>{
     List<Produit> findProduitsByNomContains(String Nom);
     List<Produit> findProduitsByEtat(EEtat etat);




}
