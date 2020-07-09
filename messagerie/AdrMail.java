package com.messagerie;
import java.math.BigInteger;
import java.util.Scanner;

public class AdrMail{
    // Attributs
    String pseudo;
    String site;
    String mp;
    Profil profil;
    BoiteMail boite;

    // Constructeurs
    public AdrMail(){}
    public AdrMail(AdrMail adresse){
        this.pseudo = adresse.pseudo;
        this.site = adresse.site;
        this.mp = adresse.mp;
        this.profil = adresse.profil;
    }
    public AdrMail(String pseudo, String site, String mp, Profil profil, BoiteMail boite){
        this.pseudo = pseudo;
        this.site = site;
        this.mp = mp;
        this.profil = profil;
        this.boite = boite;
    }

    // Accesseurs
    public String getPseudonyme(){return this.pseudo;}
    public String getSite(){return this.site;}
    public String getMotDePasse(){return this.mp;}
    public Profil getProfil(){return this.profil;}
    public BoiteMail getBoite(){return this.boite;}
    public String getNom(){return this.profil.nom;}
    public String getPrenom(){return this.profil.prenom;}

    // Mutateurs
    public void setPseudonyme(){
        boolean valide;
        String pseudo = "";

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("- Pseudonyme: ");
            try {
                pseudo = in.next();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                setPseudonyme();
            }
            valide = pseudoValide(pseudo);
        }while(!valide);

        this.pseudo = pseudo;
    }
    public void setSite(){
        boolean valide;
        String site = "";

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("- Site: ");
            try {
                site = in.next();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                setSite();
            }
            valide = siteValide(site);
        }while(!valide);

        this.site = site;
    }
    public String setMotDePasse(){
        boolean valide;
        String mp = "";

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("- Mot de Passe: ");
            try {
                mp = in.next();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                setMotDePasse();
            }
            valide = motDePasseValide(mp);
        }while(!valide);

        return mp;
    }
    public void setBoiteMail(BoiteMail boite){
        this.boite = boite;
    }

    // Methodes
    // Verifier la validite du pseudonyme.
    public boolean pseudoValide(String pseudo){
        //doit commencer par une lettre, que les caracteres "-, _, ."
        int i, length = pseudo.length();

        // Pseudonym ne peut pas etre vide
        if(pseudo.isEmpty()){
            System.out.println("Veuillez saisir une pseudonyme.");
            return false;
        }
        if(!Character.isLetter(pseudo.charAt(0))){
            System.out.println("Pseudonyme doit commencer avec une lettre.");
            return false;
        }
        // Pseudonyme ne peut pas contenir un espace
        for(i = 0; i<length; i++){
            if(pseudo.charAt(i) == ' '){
                System.out.println("Pseudonyme ne peut pas contenir des espaces.");
                return false;
            }
        }
        // Pseudonyme peut contenir que '.', '-' et '_' comme caracteres speciaux
        for(i = 0; i<length; i++){
            if(!Character.isLetterOrDigit(pseudo.charAt(i))){
                if(pseudo.charAt(i) != '.' && pseudo.charAt(i) != '-' & pseudo.charAt(i) != '_' )
                System.out.println("Pseudonyme ne peut pas contenir ce caractere special.");
                return false;
            }
        }

        return true;
    }
    // Verifier la validite du mot de passe.
    public boolean motDePasseValide(String mp){
        int i, length = mp.length(), a = 0, b = 0, c = 0;

        // Mot de passe ne peut pas etre vide
        if(pseudo.isEmpty()){
            System.out.println("Veuillez saisir un mot de passe.");
            return false;
        }
        // Mot de passe doit contenir au moins 8 caracteres
        if(length < 8){
            System.out.println("Mot de passe doit depasser les 8 caracteres.");
            return false;
        }
        // Mot de passe ne peut pas contenir un espace
        for(i = 0; i<length; i++){
            if(mp.charAt(i) == ' '){
                System.out.println("Mot de passe ne peut pas contenir des espaces.");
                return false;
            }
        }
        // Mot de passe doit contenir au moins une lettre, un chiffre et un caractere special
        for(i = 0; i < length; i++){
            if(Character.isLetter(mp.charAt(i))) a++;
            if(Character.isDigit(mp.charAt(i))) b++;
            if(!Character.isLetterOrDigit(mp.charAt(i))) c++;
        }
        if(a == 0){
            System.out.println("Mot de passe doit contenir au moins une lettre.");
            return false;
        }
        if(b == 0){
            System.out.println("Mot de passe doit contenir au moins un chiffre.");
            return false;
        }
        if(c == 0){
            System.out.println("Mot de passe doit contenir au moins un caractere special.");
            return false;
        }

        return true;
    }
    // Verifier la validite du site.
    public boolean siteValide(String site){
        int i, length = site.length(), a = 0;

        // Domain name ne peut pas etre vide
        if(site.isEmpty()){
            System.out.println("Veuillez saisir une adresse email.");
            return false;
        }
        // Domain name ne doit pas commencer avec un point
        if(site.charAt(0) == '.'){
            System.out.println("Adresse email invalide.");
            return false;
        }
        // Domain name ne doit pas se terminer avec un point
        if(site.charAt(length-1) == '.'){
            System.out.println("Adresse email invalide.");
            return false;
        }
        // Domain name ne doit pas contenir un espace
        for(i = 0; i<length; i++){
            if(site.charAt(i) == ' '){
                System.out.println("Adresse email invalide.");
                return false;
            }
        }
        // Domain name doit contenir un point
        for(i = 0; i<length; i++)
            if(site.charAt(i) == '.') a++;
        if(a == 0){
            System.out.println("Adresse email invalide.");
            return false;
        }

        return true;
    }

    // Saisir l'adresse mail.
    public AdrMail Saisir(){
        Profil profil = new Profil();
        BoiteMail boiteMail = new BoiteMail();

        this.setPseudonyme();
        this.setSite();
        this.mp = setMotDePasse();
        this.profil = profil.Saisir();
        this.boite = boiteMail;

        return this;
    }

    public void ModifierMotDePasse(){
        Scanner in = new Scanner(System.in);
        String ancien_mp = "";

        System.out.print("- Ancien mot de passe: ");
        try {
            ancien_mp = in.next();
        }catch (Exception ex){
            System.out.println("Invalid Input...");
            ModifierMotDePasse();
        }

        if(ancien_mp == this.mp){
            // Correct! Changer mot de passe
            String nouveau_mp = setMotDePasse();
            // Confirmation...
            System.out.print("- Confirmer mot de passe: ");
            try {
                ancien_mp = in.next();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                ModifierMotDePasse();
            }
            if(ancien_mp == nouveau_mp) {
                this.mp = nouveau_mp;
                System.out.println("Votre mot de passe a ete modifier!");
            }
            else
                System.out.println("Les mots de passe que vous avez entre ne sont pas correspondants.");
        }else{
            // Incorrect...
            System.out.println("Le mot de passe que vous avez saisie est incorrect...");
        }
    }

    // Verifier l'egalite entre deux adresses mails.
    public boolean Equals(AdrMail adresse){
        if(this == adresse)
            return true;
        else
            return false;
    }
    public void Afficher(){
        System.out.println(this.pseudo + "@" + this.site);
    }
    // Afficher d'apres un format specifique.
    public String toString(){
        return(this.pseudo + "@" + this.site);
    }
}
