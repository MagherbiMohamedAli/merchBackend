package com.pfa.backendpfa.controller;

import com.pfa.backendpfa.model.Commande;
import com.pfa.backendpfa.requests.CmdReq;
import com.pfa.backendpfa.services.impl.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService;

    @PostMapping("/passercom")
    public ResponseEntity<?> passerCom(@RequestBody CmdReq cmdReq) {
        return new ResponseEntity<>(commandeService.passerCommande(cmdReq.getLigneCommandeList(),cmdReq.getClient()), HttpStatus.OK);

    }

    @PostMapping("/annulercom")
    public ResponseEntity<?> annulerCom(@RequestBody Commande cmd) {

        return new ResponseEntity<>(commandeService.annulerCommande(cmd), HttpStatus.OK);
    }
}