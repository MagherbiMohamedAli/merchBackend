### Diag usecase Global
```plantuml
@startuml
left to right direction
skinparam actor awesome
mainframe UC: **diagramme de cas d'utilisation global**
actor Client as U
actor Admin as U1
actor Vendeur as U2

U <|-U1
U1 -|>U2

rectangle   {
usecase "S'authentifier" as UC1
usecase "Gérer les commandes" as UC2
usecase "Annuler les commandes" as UC3
usecase "Confirmer les commandes" as UC4





usecase "Gérer les produits" as UC12
usecase "Modifier les produits" as UC13
usecase "Supprimer les produits" as UC14
usecase "Ajouter les produits" as UC15





UC12 <|-right- UC13
UC12 <|-left- UC14
UC12 <|-- UC15

usecase "Gérer le compte" as UC22
usecase "Modifier le compte" as UC23
usecase "Supprimer le compte" as UC24



UC12 --> UC1#line.dashed;: <<include>>
UC2 --> UC1#line.dashed;: <<include>>
UC22 --> UC1#line.dashed;: <<include>>
UC22 <|-right- UC23
UC22 <|-left- UC24
UC2 <|-right- UC3
UC2 <|-left- UC4
U --- UC2
U --- UC22

U2 - UC12
U2 -- UC22








}
@enduml

### Diag classe Global



### Diag usecase s'authentifier
```plantuml
@startuml
left to right direction
skinparam actor awesome 
mainframe UC: **S'authentifier**
actor Utilisateur as U
rectangle   {
usecase "S'authentifier" as UC1
usecase "S'inscrire" as UC2




U -- UC1
UC1 --> UC2#line.dashed;: <<include>>
}
@enduml


```
### Diag usecase gerer compte
```plantuml
@startuml
left to right direction
skinparam actor awesome 
mainframe UC: **Gérer les comptes**
actor Utilisateur as U
rectangle   {
usecase "S'authentifier" as UC1
usecase "Gérer le compte" as UC2
usecase "Modifier le compte" as UC3
usecase "Supprimer le compte" as UC4



U -- UC2

UC2 --> UC1#line.dashed;: <<include>>
UC2 <|-- UC3
UC2 <|-- UC4

}
@enduml


```
### Diag usecase gerer produit
```plantuml
@startuml
left to right direction
skinparam actor awesome 
mainframe UC: **Gérer les produits**
actor Vendeur as U
actor Admin as U1

U <|-U1

rectangle   {
usecase "S'authentifier" as UC1
usecase "Gérer les produits" as UC2
usecase "Modifier les produits" as UC3
usecase "Supprimer les produits" as UC4
usecase "Ajouter les produits" as UC5




U -- UC2

UC2 --> UC1#line.dashed;: <<include>>
UC2 <|-- UC3
UC2 <|-- UC4
UC2 <|-- UC5


}
@enduml


```

### Diag usecase gerer commande
```plantuml
@startuml
left to right direction
skinparam actor awesome 
mainframe UC: **Gérer les commandes**
actor Client as U
actor Admin as U1

U <|-U1

rectangle   {
usecase "S'authentifier" as UC1
usecase "Gérer les commandes" as UC2
usecase "Annuler les commandes" as UC3
usecase "Confirmer les commandes" as UC4




U -- UC2

UC2 --> UC1#line.dashed;: <<include>>
UC2 <|-- UC3
UC2 <|-- UC4


}
@enduml


```
### Diag de classe s'authentifier
```plantuml
@startuml
mainframe CD: **S'authentifier**


class Utilisateur {
    -id: int
    -nom: String
    -prenom: String
    -dateNaissance:Date
    -adresse:string
    -mail:string
    -codePostal:string
    +login()
    +updateAccount(Account)
    +DeleteAccount(id)

}

class Vendeur {
    +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
}

class Admin{
     +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
    +ConfirmCommande()
    +CancelCommand()
}

class Client{
     +ConfirmCommande()
     +CancelCommand()
}


class Compte {
  -idCompte:int
  -Login:string
  -password:string
  -idUtilisateur:int
  +getByLogin(login)
  +findCompteByEmail(email)
  +ModierCompte()
}

enum ERole{
-Admin
-Client
-Vendeur
}

class Role{
    -idRole:int
    -role:ERole
}

class Compte_Role{
    -idCompte:int
    -idRole:int
}





Utilisateur<|-- Vendeur 
Utilisateur <|-- Admin
Utilisateur <|-- Client

Utilisateur "1..1" -- "1..1" Compte  : Possède >
Role "1..1" -- "1..1" Compte 
Role -> ERole
(Compte,Role) . Compte_Role

@enduml
```


### Diag de classe gerer compte
```plantuml
@startuml
mainframe CD: **Gérer compte**


class Utilisateur {
    -id: int
    -nom: String
    -prenom: String
    -dateNaissance:Date
    -adresse:string
    -mail:string
    -codePostal:string
    +login()
    +updateAccount(Account)
    +DeleteAccount(id)

}

class Vendeur {
    +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
}

class Admin{
     +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
    +ConfirmCommande()
    +CancelCommand()
}

class Client{
     +ConfirmCommande()
     +CancelCommand()
}


class Compte {
  -idCompte:int
  -Login:string
  -password:string
  -idUtilisateur:int
  +getByLogin(login)
  +findCompteByEmail(email)
  +changePassword()
}








Utilisateur<|-- Vendeur 
Utilisateur <|-- Admin
Utilisateur <|-- Client

Utilisateur "1..1" -- "1..1" Compte  : Possède >
@enduml
```


### Diag de classe gerer produit
```plantuml
@startuml
mainframe CD: **Gérer produit**


class Utilisateur {
    -id: int
    -nom: String
    -prenom: String
    -dateNaissance:Date
    -adresse:string
    -mail:string
    -codePostal:string
    +login()
    +updateAccount(Account)
    +DeleteAccount(id)

}

class Vendeur {
    +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
}

class Admin{
     +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
    +ConfirmCommande()
    +CancelCommand()
}

class Client{
     +ConfirmCommande()
     +CancelCommand()
}


class Compte {
  -idCompte:int
  -Login:string
  -password:string
  -idUtilisateur:int
  +getByLogin(login)
  +findCompteByEmail(email)
  +changePassword()
}
class Produit {
    -idProduct:int
    -etat:String
    -couleur:string
    -pathImage:String
    -taille:String
    -nom:string
}








Utilisateur<|-- Vendeur 
Utilisateur <|-- Admin
Utilisateur <|-- Client

Utilisateur "1..1" -- "1..1" Compte  : Possède >
Vendeur "1..1" -- "0..*" Produit  
Admin "1..1" -- "0..*" Produit  

@enduml
```

### Diag de classe gerer commande
```plantuml
@startuml
mainframe CD: **Gérer commandes**


class Utilisateur {
    -id: int
    -nom: String
    -prenom: String
    -dateNaissance:Date
    -adresse:string
    -mail:string
    -codePostal:string
    +login()
    +updateAccount(Account)
    +DeleteAccount(id)

}

class Vendeur {
    +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
}

class Admin{
     +AddProduct()
    +DeleteProduct()
    +UpdateProduct()
    +ConfirmCommande()
    +CancelCommand()
}

class Client{
     +ConfirmCommande()
     +CancelCommand()
}


class Compte {
  -idCompte:int
  -Login:string
  -password:string
  -idUtilisateur:int
  +getByLogin(login)
  +findCompteByEmail(email)
  +changePassword()
}
class Commande {
    -idCommande:int
    -etat:String
    -prix:float
    -dateCommande:date
}
Utilisateur<|-- Vendeur 
Utilisateur <|-- Admin
Utilisateur <|-- Client

Utilisateur "1..1" -- "1..1" Compte  : Possède >
Client "1..1" -- "0..*" Commande  
Admin "1..1" -- "0..*" Commande  

@enduml
```
### Diagramme de séquence s'authentifier

```plantuml
@startuml
mainframe SD: **S'authentifier**

participant "Utilisateur" as Médecin_Contrôleur
participant "Espace Merch" as IHM
participant ":__AuthRest__" as AR
participant ":__AuthTokenFilter__" as ATF
participant ":__JwtUtils__" as JU
participant ":__CompteDetailsServiceImpl__" as CDSI
participant ":__CompteDao__" as CD
participant "BD:User" as BD

activate Médecin_Contrôleur #FFF9B0
Médecin_Contrôleur -> IHM : Entrer login et password
activate IHM #FFF9B0


IHM ->> ATF : Tentative d'authentification

activate ATF #FFF9B0
ATF ->> CDSI : LoadUserByLogin()
activate CDSI #FFF9B0
CDSI ->> CD : FindByLogin()
activate CD #FFF9B0
CD ->> BD : Demander données 
activate BD #FFF9B0
BD --> CD : Retourne résultats
deactivate CDSI #FFF9B0
deactivate BD #FFF9B0
deactivate ATF #FFF9B0
alt#FFF9B0 [Login inexistant ]

    CD --> CDSI : Résultat vide
    activate CDSI #FFF9B0
        deactivate CD #FFF9B0

    CDSI --> JU : Compte non trouvé
    deactivate CDSI #FFF9B0
    activate JU #FFF9B0
    JU --> IHM : Un message d'erreur
    deactivate JU #FFF9B0
    IHM --> Médecin_Contrôleur : Afficher un message d'erreur

else [ Login existant]
    CD --> CDSI : Résultat non vide
    deactivate CD
    activate CDSI #FFF9B0
    CDSI --> JU : Compte trouvé
    deactivate CDSI #FFF9B0
    activate JU #FFF9B0
    JU --> ATF : Compte trouvé
    deactivate JU
    activate ATF #FFF9B0
    ATF -> ATF : Vérifier password
    alt#FFF9B0 [Données invalide ]
        ATF --> IHM : Un message d'erreur
        deactivate IHM
                IHM --> Médecin_Contrôleur : Afficher un message d'erreur

    else [Password valide]
        ATF --> JU : Authentification réussie
        activate JU #FFF9B0
        deactivate ATF #FFF9B0
        JU --> CDSI : Construire JWT
        deactivate JU
        activate CDSI #FFF9B0
        CDSI --> JU : JWT
        deactivate CDSI
        activate JU #FFF9B0
        JU --> AR : ResponseHeaders : Authorization Bearer JWT 
        activate AR #FFF9B0
        deactivate JU
        activate IHM #FFF9B0
        AR --> IHM : ResponseHeaders : Authorization Bearer JWT 
        IHM --> Médecin_Contrôleur : Rédiriger vers l'accueil
        deactivate Médecin_Contrôleur #FFF9B0
        deactivate AR
            deactivate IHM 

    end
end
@enduml
```



### Diagramme de séquence Modifier compte

```plantuml
@startuml
mainframe SD : **Modifier le compte**
participant "Utilisateur" as Médecin_Contrôleur
participant "Espace Merch" as IHM 
participant ": __UserController__" as CR
participant ": __UserDao__" as CD
participant "BD : user" as DB 
ref over Médecin_Contrôleur,IHM,CR,CD,DB:Authentification

activate Médecin_Contrôleur #FFF9B0
Médecin_Contrôleur ->> IHM : Consulter le compte
activate IHM #FFF9B0
IHM -->> Médecin_Contrôleur :Afficher l'interface de compte 
Médecin_Contrôleur -> IHM : Remplir les champs  à modifier
IHM -> IHM : Vérifier les champs 
activate IHM #FFF9B0
deactivate IHM #FFF9B0


IHM -> CR : EditRequest
activate CR #FFF9B0
CR -> CD : miseAJour(EditRequest)
deactivate CR #FFF9B0
activate CD #FFF9B0

CD -> DB : findById(id)  
activate DB #FFF9B0
    DB -->> CD : Résultat
    deactivate DB #FFF9B0
   
    



alt#FFF9B0 ["Compte non trouvé" ]
     CD -->> CR : Résultat vide 
    activate CR #FFF9B0
    CR -->> IHM : Un message d'erreur
    IHM -->> Médecin_Contrôleur : Afficher un message d'erreur
else ["Compte trouvé"] 
    CR->> CD : Save (Request)
    CD -->> DB : Enregistrer
    activate DB #FFF9B0

    DB -->> CD : Confirmer
        deactivate DB #FFF9B0

    CD -->> CR : Confirmer
    CR -->> IHM : Un message de validation
    deactivate DB #FFF9B0
    IHM -->> Médecin_Contrôleur : Afficher un message de validation
    deactivate CD #FFF9B0
        deactivate CR #FFF9B0
    deactivate IHM #FFF9B0
    deactivate Médecin_Contrôleur #FFF9B0
end
@enduml
```

### Diagramme de séquence Ajouter produit

```plantuml
@startuml
mainframe SD : **Ajouter un produit**
participant "Vendeur" as Médecin_Contrôleur
participant "Espace Merch" as IHM 
participant ": __ProduitController__" as CR
participant ": __ProduitDao__" as CD
participant "BD : Prodruit" as DB 
ref over Médecin_Contrôleur,IHM,CR,CD,DB:Authentification

activate Médecin_Contrôleur #FFF9B0
Médecin_Contrôleur ->> IHM : Consulter l'interface d'ajout de produit
activate IHM #FFF9B0
IHM -->> Médecin_Contrôleur :Afficher l'interface d'ajout 
Médecin_Contrôleur -> IHM : Remplir les champs de produit
IHM -> IHM : Vérifier les champs 
activate IHM #FFF9B0
deactivate IHM #FFF9B0
IHM -> CR : AddProduit(produit)
activate CR #FFF9B0
CR -> CD : save(produit)
deactivate CR #FFF9B0
activate CD #FFF9B0

CD -> DB : Enregistrer  
activate DB #FFF9B0
    DB -->> CD : Résultat
    deactivate DB #FFF9B0



    CD -->> CR : Confirmer
            deactivate CD #FFF9B0
activate CR #FFF9B0

    CR -->> IHM : Un message de validation
    deactivate CR #FFF9B0

    deactivate DB #FFF9B0
    IHM -->> Médecin_Contrôleur : Afficher un message de validation
    deactivate CD #FFF9B0
        deactivate CR #FFF9B0
    deactivate IHM #FFF9B0
    deactivate Médecin_Contrôleur #FFF9B0
@enduml
```


### Diagramme de séquence Confirmer commande

```plantuml
@startuml
mainframe SD : **Confirmer la commande**
participant "Client" as Médecin_Contrôleur
participant "Espace Merch" as IHM 
participant ": __CommandeController__" as CR
participant ": __CommandeDao__" as CD
participant "BD : Commande" as DB 
ref over Médecin_Contrôleur,IHM,CR,CD,DB:Authentification

activate Médecin_Contrôleur #FFF9B0
Médecin_Contrôleur ->> IHM : Consulter l'interface panier
activate IHM #FFF9B0
IHM -->> Médecin_Contrôleur :Afficher l'interface panier 
Médecin_Contrôleur -> IHM : Confirmer la commande



IHM -> CR : passerCom(cmdRequest)
activate CR #FFF9B0
CR -> CD : passerCommande(cmdRequest)
deactivate CR #FFF9B0
activate CD #FFF9B0

CD -> DB : Enregistrer
activate DB #FFF9B0
    DB -->> CD : Résultat
    deactivate DB #FFF9B0
   
    



        deactivate DB #FFF9B0

    CD -->> CR : Confirmer
            activate CR #FFF9B0

    CR -->> IHM : Un message de validation
                deactivate CR #FFF9B0

    deactivate DB #FFF9B0
    IHM -->> Médecin_Contrôleur : Afficher un message de validation
    deactivate CD #FFF9B0
        deactivate CR #FFF9B0
    deactivate IHM #FFF9B0
    deactivate Médecin_Contrôleur #FFF9B0
@enduml
```







