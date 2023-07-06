package com.pfa.backendpfa.model;



import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    @Column(unique = true,nullable = false)
    private String email;
    @Temporal(TemporalType.DATE)
    private Date datedenaissance;
    private String adresse;
    private Long codepostal;
    private String password;
    @ManyToMany
    private Set<Role> roles;


}


