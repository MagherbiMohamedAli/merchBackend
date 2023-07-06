package com.pfa.backendpfa.services.impl;

import com.pfa.backendpfa.dao.RoleDao;
import com.pfa.backendpfa.dao.UserDao;
import com.pfa.backendpfa.model.ERole;
import com.pfa.backendpfa.model.Role;
import com.pfa.backendpfa.model.User;
import com.pfa.backendpfa.services.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUser {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;



    @Override
    public User ajouterUtilisateur(User u) {

        return userDao.save(u);
    }

    @Override
    public List<User> afficherTousLesUtilisateur() {
        return userDao.findAll();
    }

    @Override
    public User miseajourUtilisateur(User u) {
        return userDao.save(u);
    }

    @Override
    public User afficherUtilisateurparid(Long id) {
        return userDao.findById(id).orElseThrow();
    }
    public Boolean supprimerUtilisateur(User u){
        if(userDao.existsById(u.getId())){
            userDao.delete(u);
            return !userDao.existsById(u.getId());
        }
        return false;
     }
     public User ajouterRoleVenduerToUser(Long id){
        Set<Role> roles ;
        User u=afficherUtilisateurparid(id);
        roles=  u.getRoles();
         roles.add(roleDao.findRoleByRole(ERole.VENDEUR));



         u.setRoles(roles);
        return userDao.save(u);
     }
}
