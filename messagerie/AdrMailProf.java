package com.messagerie;

import java.math.BigInteger;
import java.util.Scanner;

public class AdrMailProf extends AdrMail{
    // Attributs
    String entreprise;
    Domaine domaine;

    // Constructeurs
    public AdrMailProf(){}
    public AdrMailProf(AdrMailProf adresse){
        this.pseudo = adresse.pseudo;
        this.site = adresse.site;
        this.mp = adresse.mp;
        this.profil = adresse.profil;
        this.entreprise = adresse.entreprise;
        this.domaine = adresse.domaine;
    }
    public AdrMailProf(String pseudo, String site, String mp, Profil profil, BoiteMail boite, String entreprise, Domaine domaine){
        super(pseudo, site, mp, profil, boite);
        this.entreprise = entreprise;
        this.domaine = domaine;
    }

    // Accesseurs
    public String getEntreprise(){return this.entreprise;}
    public Domaine getDomaine(AdrMailProf adresse){return adresse.domaine;}

    // Mutateurs
    public String setEntreprise(){
        Scanner in = new Scanner(System.in);
        String entreprise = "";

        do {
            System.out.print("- Entreprise: ");
            try {
                entreprise = in.nextLine();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                setEntreprise();
            }
        }while(entreprise.isEmpty());

        return entreprise;
    }
    public int setDomaine(){
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            System.out.print("- Domaine (1) Recherche, (2) Production, (3) Education, (4) Sante, (5) Enseignement_superieur: ");
            try {
                option = in.nextInt();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                setDomaine();
            }
        }while(option < 0 && option > 6);

        return option;
    }

    // Methodes
    // Saisir l'adresse mail professionelle.
    public AdrMailProf Saisir(){
        AdrMail adrMail = new AdrMail();
        AdrMailProf adrMailProf = new AdrMailProf();

        adrMail.Saisir();
        adrMailProf.pseudo = adrMail.getPseudonyme();
        adrMailProf.site = adrMail.getSite();
        adrMailProf.mp = adrMail.getMotDePasse();
        adrMailProf.profil = adrMail.getProfil();
        adrMailProf.boite = adrMail.getBoite();

        adrMailProf.entreprise = setEntreprise();
        adrMailProf.domaine = Domaine.values()[setDomaine()-1];

        return adrMailProf;
    }

    // Verifier l'egalite entre deux adresses mail professionelles.
    public boolean Equals(AdrMailProf adresse){
        if(this == adresse)
            return true;
        else
            return false;
    }

    // Afficher d'apres un format specifique.
    public String toString(){
        return(this.pseudo + "@" + this.site);
    }

    // Inner Class
    public enum Domaine {recherche, production, education, sante, enseignement_superieur}
}
