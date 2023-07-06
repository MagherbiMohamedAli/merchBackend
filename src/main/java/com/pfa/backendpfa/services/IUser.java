package com.pfa.backendpfa.services;


import com.pfa.backendpfa.model.User;

import java.util.List;

public interface IUser {
    User ajouterUtilisateur(User u);
    List<User> afficherTousLesUtilisateur();
    User miseajourUtilisateur(User u);
    User afficherUtilisateurparid(Long id);
    User ajouterRoleVenduerToUser(Long id);

    Boolean supprimerUtilisateur(User u);

}
