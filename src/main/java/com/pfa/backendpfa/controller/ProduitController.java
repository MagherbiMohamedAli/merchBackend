package com.pfa.backendpfa.controller;

import com.pfa.backendpfa.dao.ProduitDao;
import com.pfa.backendpfa.model.Produit;
import com.pfa.backendpfa.model.User;
import com.pfa.backendpfa.requests.Message;
import com.pfa.backendpfa.services.IProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/produit")
@CrossOrigin("*")
public class ProduitController {
@Autowired
    IProduit produitService;
@Autowired
    ProduitDao produitDao;
    @GetMapping("/getallp")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(produitService.afficherTousLesProduit(), HttpStatus.OK);
    }
    @GetMapping("/getallproduitconfirmer")
    public ResponseEntity<?> getAllProdConfirmer(){
        return new ResponseEntity<>(produitService.afficherTousLesProduitConfirmer(), HttpStatus.OK);
    }
    @GetMapping("/getpbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        return new ResponseEntity<>(produitService.afficherProduitparid(id),HttpStatus.OK);
    }
    @GetMapping("/getBytitre/{titre}")
    public ResponseEntity<?> getByTtire(@PathVariable String titre){
        return new ResponseEntity<>(produitService.affichierProduitParTitre(titre),HttpStatus.OK);
    }

    @PostMapping("/ajouterp")
    public ResponseEntity<?> ajoutp(@RequestBody Produit p){
        return new ResponseEntity<>( produitService.ajouterProduit(p), HttpStatus.OK);

    }
    @PutMapping("/Miseajourp")
    public ResponseEntity<?> miseajour(@RequestBody Produit p){
        return new ResponseEntity<>(produitService.miseajourProduit(p),HttpStatus.OK);
    }
    @PostMapping("/confirmerProduit/{id}")
    public ResponseEntity<?> confirmerProduit(@PathVariable Long id){
        return new ResponseEntity<>( produitService.confirmerProduit(id), HttpStatus.OK);

    }
    @PostMapping("/annulerProduit/{id}")
    public ResponseEntity<?> annulerProduit(@PathVariable Long id){
        return new ResponseEntity<>( produitService.annulerProduit(id), HttpStatus.OK);

    }

    @DeleteMapping("/deletep")
    public ResponseEntity<?> supprimerproduit(@RequestBody Produit p ){
        if(produitDao.existsById(p.getId())) {
            return new ResponseEntity<>(new Message("Produit Non Supprimé"),HttpStatus.NOT_FOUND);

        }
        if (produitService.supprimerProduit(p)){
            return new ResponseEntity<>(new Message("Produit Supprimé avec succèes"),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Message("Produit Non Supprimé"),HttpStatus.NOT_FOUND);

        }
    }


}