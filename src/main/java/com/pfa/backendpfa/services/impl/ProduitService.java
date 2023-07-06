package com.pfa.backendpfa.services.impl;

import com.pfa.backendpfa.dao.ProduitDao;
import com.pfa.backendpfa.dao.RoleDao;
import com.pfa.backendpfa.model.EEtat;
import com.pfa.backendpfa.model.Produit;
import com.pfa.backendpfa.services.IProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService implements IProduit {
    @Autowired
    ProduitDao produitDao;
    @Override
    public Produit ajouterProduit(Produit p) {
        p.setEtat(EEtat.EN_COURS);
        return produitDao.save(p);
    }

    @Override
    public List<Produit> afficherTousLesProduitConfirmer() {

        return produitDao.findAll();
    }

    @Override
    public List<Produit> afficherTousLesProduit() {
        return produitDao.findProduitsByEtat(EEtat.CONFIRME);
    }

    @Override
    public Produit miseajourProduit(Produit p) {
        return produitDao.save(p);
    }

    @Override
    public Produit afficherProduitparid(Long id){
        return produitDao.findById(id).orElseThrow();
    }

    @Override
    public Boolean supprimerProduit(Produit p) {
        if(produitDao.existsById(p.getId())){
            produitDao.delete(p);
            return !produitDao.existsById(p.getId());
        }
        return false;
    }

    @Override
    public Produit annulerProduit(Long id) {
        Produit prd = produitDao.findById(id).orElseThrow();
        prd.setEtat(EEtat.ANNULE);
        return produitDao.save(prd);
    }

    @Override
    public Produit confirmerProduit(Long p) {
        Produit prd = produitDao.findById(p).orElseThrow();
        prd.setEtat(EEtat.CONFIRME);
        return produitDao.save(prd);
    }

    @Override
    public List<Produit> affichierProduitParTitre(String titre) {
        return produitDao.findProduitsByNomContains(titre);
    }
}
