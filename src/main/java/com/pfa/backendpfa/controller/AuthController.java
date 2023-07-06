package com.pfa.backendpfa.controller;

import com.pfa.backendpfa.dao.RoleDao;
import com.pfa.backendpfa.dao.UserDao;
import com.pfa.backendpfa.model.ERole;
import com.pfa.backendpfa.model.User;
import com.pfa.backendpfa.requests.LoginReq;
import com.pfa.backendpfa.requests.Message;
import com.pfa.backendpfa.response.JwtResponse;
import com.pfa.backendpfa.security.jwt.JwtProvider;
import com.pfa.backendpfa.security.jwt.service.UserPrincipal;
import com.pfa.backendpfa.services.IUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Auth")
public class AuthController {
    @Autowired
    UserDao userDao;
    @Autowired
    IUser userService;
    @Autowired
    RoleDao roleDao;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;




    @PostMapping("/Connexion")
    public ResponseEntity<?> connection(@RequestBody LoginReq loginReq){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        User user = userService.afficherUtilisateurparid(userDetails.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(jwt, userDetails.getUsername(), user));


    }
    @PostMapping("/inscrireClient")
    public ResponseEntity<?> addClient(@RequestBody User user){
        if(userDao.existsByEmail(user.getEmail())){
            return new ResponseEntity<>( new Message("Email Already exist"), HttpStatus.BAD_REQUEST);
        }

        user.setRoles(roleDao.findRolesByRole(ERole.CLIENT));
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>( userService.ajouterUtilisateur(user), HttpStatus.OK);
    }
    @PostMapping("/inscrireVendeur")
    public ResponseEntity<?> addVendeur(@RequestBody User user){
        if(userDao.existsByEmail(user.getEmail())){
            return new ResponseEntity<>( new Message("Email Already exist"), HttpStatus.BAD_REQUEST);
        }

        user.setRoles(roleDao.findRolesByRole(ERole.VENDEUR));
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>( userService.ajouterUtilisateur(user), HttpStatus.OK);
    }

    @PostMapping("/inscrireAdmin")
    public ResponseEntity<?> addAdmin(@RequestBody User user){
        if(userDao.existsByEmail(user.getEmail())){
            return new ResponseEntity<>( new Message("Email Already exist"), HttpStatus.BAD_REQUEST);
        }

        user.setRoles(roleDao.findRolesByRole(ERole.ADMIN));
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>( userService.ajouterUtilisateur(user), HttpStatus.OK);
    }
}
