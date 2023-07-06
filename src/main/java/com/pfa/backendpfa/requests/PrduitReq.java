package com.pfa.backendpfa.requests;

import com.pfa.backendpfa.model.EEtat;
import com.pfa.backendpfa.model.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

public class PrduitReq {
    private String nom;
    @Enumerated(EnumType.STRING)
    private EEtat etat;
    private String couleur;



    private float prix;


    private List<User> vendeurs;
}
