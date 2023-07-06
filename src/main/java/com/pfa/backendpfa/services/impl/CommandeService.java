package com.pfa.backendpfa.services.impl;

import com.pfa.backendpfa.dao.CommandeDao;
import com.pfa.backendpfa.dao.LigneCommandeDao;
import com.pfa.backendpfa.model.*;
import com.pfa.backendpfa.services.ICommande;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CommandeService implements ICommande {

    CommandeDao commandeDao;
    LigneCommandeDao ligneCommandeDao;

    @Override
    public Commande passerCommande(List<LigneCommande> ligneCommandes, User clients) {
        List<LigneCommande> list=new ArrayList<>();
        Float prix = null;
        for(LigneCommande lc:ligneCommandes){
            list.add(ligneCommandeDao.save(lc));
            prix = prix +lc.getPrixtotale();
        }
        Commande cmd = new Commande();
        cmd.setLigneCommandes(list);
        cmd.setClient(clients);
        cmd.setEtat(EEtat.EN_COURS);
        cmd.setPrix(prix);
        return commandeDao.save(cmd);
    }

    @Override
    public Commande confirmerCommande(Commande cmd) {
        Commande commande = commandeDao.findById(cmd.getId()).orElseThrow();
        commande.setEtat(EEtat.CONFIRME);
        return commandeDao.save(commande);
    }

    @Override
    public Commande annulerCommande(Commande cmd) {
        Commande commande = commandeDao.findById(cmd.getId()).orElseThrow();
        commande.setEtat(EEtat.ANNULE);
        return commandeDao.save(commande);
    }
}
