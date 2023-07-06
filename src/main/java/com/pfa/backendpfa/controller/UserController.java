package com.pfa.backendpfa.controller;
import com.pfa.backendpfa.dao.UserDao;
import com.pfa.backendpfa.model.User;
import com.pfa.backendpfa.requests.Message;
import com.pfa.backendpfa.services.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    IUser userService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.afficherTousLesUtilisateur(), HttpStatus.OK);
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        Optional<User> user = userDao.findById(id);
        if (user.isPresent())
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(new Message("Utilisateur Introuvable"), HttpStatus.FORBIDDEN);
    }
    @GetMapping("/AjouterRole/{id}")
    public ResponseEntity<?> addRole(@PathVariable long id){

            return new ResponseEntity<>(userService.ajouterRoleVenduerToUser(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> supprimerutilisatuer(@RequestBody User u ){
        if (userService.supprimerUtilisateur(u)){
            return new ResponseEntity<>(new Message("Utilisateur Supprimé avec succèes"),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Message("Utilisateur Non Supprimé"),HttpStatus.NOT_FOUND);

        }
    }
    @PutMapping("/Miseajour")
    public ResponseEntity<?> miseajour(@RequestBody User u){
        return new ResponseEntity<>(userService.miseajourUtilisateur(u),HttpStatus.OK);
    }

}
