package com.pfa.backendpfa.requests;

import com.pfa.backendpfa.model.LigneCommande;
import com.pfa.backendpfa.model.User;
import lombok.Data;

import java.util.List;
@Data
public class CmdReq {
    User client;
    List<LigneCommande> ligneCommandeList;
}
