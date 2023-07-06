package com.pfa.backendpfa.dao;

import com.pfa.backendpfa.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeDao extends JpaRepository<LigneCommande,Long> {
}
