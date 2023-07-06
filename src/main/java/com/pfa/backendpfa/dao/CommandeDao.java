package com.pfa.backendpfa.dao;

import com.pfa.backendpfa.model.Commande;
import com.pfa.backendpfa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CommandeDao extends JpaRepository<Commande, Long>{




}
